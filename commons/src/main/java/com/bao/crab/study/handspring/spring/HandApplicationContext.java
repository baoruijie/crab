package com.bao.crab.study.handspring.spring;

import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2024/6/6 14:29
 */


public class HandApplicationContext {

    private Class configClass;

    private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    /**
     *  @param configClass
     */
    public HandApplicationContext(Class configClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.configClass = configClass;
        //2.扫描,判断是否有扫描路径。扫描路径应该是class类所在项目的包名
        if(configClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan scan = (ComponentScan)configClass.getAnnotation(ComponentScan.class);
            String path = scan.value();
            if(!StringUtils.hasLength(path)){
                path = "默认值当前包";
            }
            path = path.replaceAll("\\.",File.separator);
            // 通过类加载器可得知包含项目名的 classpath 路径
            ClassLoader classLoader = HandApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());

            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File f : files){
                    String fileName = f.getAbsolutePath();
                    if(fileName.endsWith(".class")){

                        String pckName = fileName.substring(fileName.indexOf("classes")+8,fileName.indexOf(".class"));
                        pckName = pckName.replaceAll(File.separator,".");
                        System.out.println(fileName + "--" +pckName);
                        Class<?> aClass = classLoader.loadClass(pckName);
                        if(aClass.isAnnotationPresent(Component.class)){

                            /**
                             * 7.
                             */
                            if(BeanPostProcessor.class.isAssignableFrom(aClass)){
                                System.out.println("BeanPostProcessor.class.isAssignableFrom(aClass))");
                                BeanPostProcessor postProcessor = (BeanPostProcessor) aClass.newInstance();
                                beanPostProcessorList.add(postProcessor);
                            }

                            //beanDefinition.
                            Component component = aClass.getAnnotation(Component.class);
                            String beanName = component.value();
                            if(!StringUtils.hasLength(beanName)){
                                beanName = Introspector.decapitalize(aClass.getSimpleName());
                            }
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(aClass);
                            if(aClass.isAnnotationPresent(Scope.class)){
                                Scope scope = aClass.getAnnotation(Scope.class);
                                beanDefinition.setScope(scope.value());
                            } else{
                                beanDefinition.setScope("singleton");
                            }
                            beanDefinitionMap.put(beanName,beanDefinition);
                        }
                    }
                }
            }
        }
        //扫描结束，最后，创建单例bean
        for(String beanName :beanDefinitionMap.keySet()){
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if("singleton".equals(beanDefinition.getScope())){
                /**
                 * 3.
                 */
                Object obj = createBean(beanName,beanDefinition);
                singletonObjects.put(beanName,obj);
            }
        }
    }

    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanType = beanDefinition.getType();

        Object instance = null;
        try {
            instance = beanType.newInstance();
            /**
             * 4.依赖注入
             */
            Field[] fields = beanType.getDeclaredFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(Autowired.class)){
                    field.setAccessible(true);
                    field.set(instance,getBean(field.getName()));
                }
            }

            /**
             * 5.Aware回调
             */
            if(instance instanceof BeanNameAware){
                ((BeanNameAware) instance).setBeanName(beanName);
            }
            /**
             * 8.前置
             */
            for(BeanPostProcessor postProcessor : beanPostProcessorList){
                instance = postProcessor.postProcessBeforeInit(beanName,instance);
            }
            /**
             * 6.初始化
             */
            if(instance instanceof InitializingBean){
                ((InitializingBean) instance).afterPropertiesSet();
            }
            /**
             * 9.后置
             */
            for(BeanPostProcessor postProcessor : beanPostProcessorList){
                instance = postProcessor.postProcessAfterInit(beanName,instance);
            }


        }catch (Exception e){

        }

        return instance;
    }

    public Object getBean(String beanName){
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null){
            throw new NullPointerException();
        } else {
            String scope = beanDefinition.getScope();
            if("prototype".equals(scope)){
                return createBean(beanName,beanDefinition);
            }else{
                Object instance = singletonObjects.get(beanName);
                if(instance == null){
                    Object o = createBean(beanName,beanDefinition);
                    singletonObjects.put(beanName,o);
                }
                return instance;
            }
        }
    }
}
