package com.example.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbointerface.bean.User;
import com.example.dubbointerface.service.ProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActionController {


    //轮循负载均衡：loadbalance ="roundrobin" dubbo直连:url = "192.168.0.101:20880" 超时:timeout=3000  重试次数:retries = 3
    //调用本地存根：stub = "com.example.dubbointerface.serviceStub.ProviderServiceStub"
    @Reference(version = "2")
    private ProviderService providerService;


    @ResponseBody
    @RequestMapping("getUserInfo")
    @HystrixCommand(fallbackMethod = "failBack")
    public User getUserInfo(@RequestParam("userId") String userId) {
        User userInfo = providerService.getUserInfo(userId);
        return userInfo;
    }

    public User failBack(String userId) {
        System.out.println("进入容错方法。。。");
        return new User( "0",  "测试01", 0, "000000",  "测试01");
    }
}
