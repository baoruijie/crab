# springCloudAlibaba

## 引入nacos作为注册中心。
1.pom增加nacos依赖，配置文件加上nacos地址。
2.先启动nacos服务，后启动用户服务，注册到nacos
3.使用openFeign实现服务发现远程调用以及负载均衡。（导入openfeign和loadbalancer）

