package com.example.dubboconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.dubbointerface.bean.User;
import com.example.dubbointerface.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ActionController {

    @Reference
    private ProviderService providerService;

    @ResponseBody
    @RequestMapping("getUserInfo")
    public User getUserInfo(@RequestParam("userId") String userId) {
        User userInfo = providerService.getUserInfo(userId);
        return userInfo;
    }
}
