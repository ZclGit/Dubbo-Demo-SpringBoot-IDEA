package com.example.dubbointerface.service;

import com.example.dubbointerface.bean.User;

public interface ProviderService {
    User getUserInfo(String userIdd);
}
