package com.example.dubboprovider.serviceImp;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.dubbointerface.bean.User;
import com.example.dubbointerface.service.ProviderService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Service(version = "1")
@Component
public class ProviderServiceImp implements ProviderService {

    @Override
    public User getUserInfo(String userId) {
        System.out.println("ProviderService.......version 1 ........");
        User user = new User("1", "张三", 20, "320123201801013214", "江苏");
        User user1 = new User("2", "李四", 23, "230123201501016551", "上海");
        User user2 = new User("3", "王五", 26, "110123201201017891", "北京");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Map<String,Object> users = new HashMap<>();
        users.put(user.getId(),user);
        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);
        return (User) users.get(userId);
    }
}
