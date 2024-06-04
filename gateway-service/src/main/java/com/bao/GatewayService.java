package com.bao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/5/31 15:24
 */


@SpringBootApplication
//@EnableDiscoveryClient
@Slf4j
public class GatewayService {
    public static void main(String[] args) {
        SpringApplication.run(GatewayService.class,args);
    }

//    @RestController
    class EchoController {

//        @Autowired
//        private RestTemplate restTemplate;

        @GetMapping(value ="/echo/{s}")
        public String echo(@PathVariable String s){
            return "Hello world " + s;
        }

//        @GetMapping(value ="/echo2/{s}")
//        public String echo2(@PathVariable String s){
//            System.out.println("sssssss" +s);
//            return restTemplate.getForObject("http://book-service/booklist/1/2",String.class);
////            return s;
//        }

    }
}

