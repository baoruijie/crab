package com.bao.crab.schedule;

//import okhttp3.*;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

//@Component
public class HttpSendMock {
//
//    String url = "http://localhost:8080/crab/api/getInfo/3";
//    @Scheduled(cron = "*/2 * * * * ?")
//    private void process() throws IOException {
//
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("username", "zhangsan")
//                .add("password", "123456")
//                .build();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(formBody)
//                .build();
//
//        Call call = new OkHttpClient().newCall(request);
//        Response response = null;
//        try {
//            response = call.execute();
//        } catch (IOException e) {
//            System.out.println("execute failed, message:" + e.getMessage());
//        }
//
//        assert response != null;
//        if (!response.isSuccessful()) {
//            System.out.println("request failed");
//        } else {
//            System.out.println(response.body().string());
//        }
//
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        RequestBody formBody = new FormBody.Builder()
//                .add("username", "zhangsan")
//                .add("password", "123456")
//                .build();
//
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/crab/api/getInfo/3")
//                .post(formBody)
//                .build();
//
//        Call call = new OkHttpClient().newCall(request);
//        Response response = null;
//        try {
//            response = call.execute();
//        } catch (IOException e) {
//            System.out.println("execute failed, message:" + e.getMessage());
//        }
//
//        assert response != null;
//        if (!response.isSuccessful()) {
//            System.out.println("request failed");
//        }
//        System.out.println(response.toString());
//        System.out.println(response.body().toString());
//        String responseData = response.body().string();
//        System.out.println(responseData);
//        System.out.println(response.isSuccessful());
//    }

}