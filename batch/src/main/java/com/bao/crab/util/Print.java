package com.bao.crab.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @desc
 * @Author 骚包
 * @date 2024/1/13 12:20:42
 */
public class Print<T> {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private static String dateCh =  "北京时间:";
    public static String printTime(){

        Date date = new Date();
        return dateCh + sdf.format(date);
    }
    public static void p(Object object){
        p(true,null,object);
    }
    public static void p(boolean threadId,String prefix,Object content){
        StringBuffer sb = new StringBuffer();
        if(threadId){
            sb.append(Thread.currentThread().getName()).append("-->");
        }
        if(!StringUtils.isEmpty(prefix)){
            sb.append(prefix);
        }
        if(Objects.isNull(content)){
            System.out.println(sb.toString());
            return;
        }else if(content instanceof String){
            sb.append(content);
        } else {
            String.valueOf(content);
            sb.append(content);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        p("gtrfadsasdgasdg");
    }
}
