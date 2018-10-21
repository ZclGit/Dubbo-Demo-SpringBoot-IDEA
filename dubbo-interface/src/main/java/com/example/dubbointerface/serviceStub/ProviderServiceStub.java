package com.example.dubbointerface.serviceStub;

import com.example.dubbointerface.bean.User;
import com.example.dubbointerface.service.ProviderService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

public class ProviderServiceStub implements ProviderService {

    private final ProviderService providerService;

    public ProviderServiceStub(ProviderService providerService) {
        this.providerService = providerService;
    }

    @Override
    public User getUserInfo(String userId) {
        System.out.println("运行了消费者的本地存根");
        try {
            if (StringUtils.isEmpty(userId)) {
                System.out.println("userId 为空了");
                return null;
            } else {
                return providerService.getUserInfo(userId);
            }
        } catch (Exception e) {
            return null;
        }

    }
}
