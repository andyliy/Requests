package com.andy.utils;

import okhttp3.*;

import java.io.IOException;

public class Requests {
    //get 接口创建
    public static String get(String url , String params) {
            //创建OkHttpClient，继续接口自动化
            OkHttpClient clinet = new OkHttpClient();
            //创建request请求
            Request request = new Request.Builder().
                    url(url + "?" + params)
                    .get()
                    .build();
            //使用Client发送请求
        try {
            Response response = clinet.newCall(request).execute();
            System.out.println(response.code());  //输出响应编码
            System.out.println(response.headers());   //输出响应头
            String body = response.body().string();
            System.out.println(response.body().string());   //输出响应体
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //get 接口创建
    public static String post(String url , String params) {
        //创建OkHttpClient，继续接口自动化
        OkHttpClient clinet = new OkHttpClient();
        //创建request-body用于处理post请求的参数
        MediaType type= MediaType.parse("application/x-www-form-urlencode");
        RequestBody requestBody = RequestBody.create(type,params);
        //创建request请求
        Request request = new Request.Builder().
                url(url)
                .post(requestBody)
                .build();
        //使用Client发送请求
        try {
            Response response = clinet.newCall(request).execute();
            System.out.println(response.code());  //输出响应编码
            System.out.println(response.headers());   //输出响应头
            String body = response.body().string();
            System.out.println(response.body().string());   //输出响应体
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //get 接口创建调用get，post方法
    public static String call(String method , String url , String params) {
        if("get".equalsIgnoreCase(method)){ //不区分大小写判断调用什么方法
          return  get(url,params);
        }else if("post".equalsIgnoreCase(method)){
            return  post(url,params);
        }
        return null;
    }

}
