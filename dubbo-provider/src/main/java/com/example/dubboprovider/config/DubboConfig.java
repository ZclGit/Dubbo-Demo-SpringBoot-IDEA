package com.example.dubboprovider.config;

import com.alibaba.dubbo.config.*;
import com.example.dubbointerface.service.ProviderService;
import com.example.dubboprovider.serviceImp.ProviderServiceImp;
import com.example.dubboprovider.serviceImp.ProviderServiceImp2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


//@Configuration
public class DubboConfig {
    //@Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springboot-provider");
        return applicationConfig;
    }

   //@Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        return registryConfig;
    }

    //@Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    //@Bean
    public ServiceConfig<ProviderService> serviceConfig() {
        ProviderService providerService = new ProviderServiceImp2();
        ServiceConfig<ProviderService> objectServiceConfig = new ServiceConfig<>();
        objectServiceConfig.setInterface(ProviderService.class);
        objectServiceConfig.setRef(providerService);
        objectServiceConfig.setVersion("2");

        //配置每一个method信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserInfo");
        methodConfig.setTimeout(3000);

        //将method设置关联到service配置中
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);
        objectServiceConfig.setMethods(methods);
        return objectServiceConfig;
    }

}
