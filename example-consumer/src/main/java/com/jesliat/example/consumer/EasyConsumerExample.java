package com.jesliat.example.consumer;

import com.jesliat.example.common.model.User;
import com.jesliat.example.common.service.UserService;
import com.jesliat.jesrpc.proxy.ServiceProxyFactory;

public class EasyConsumerExample {
    public static void main(String[] args) {
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User testUser = new User();
        testUser.setName("Jesliat");
        //调用
        User newUser = userService.getUser(testUser);
        if (newUser != null) {
            System.out.println("用户名："+ newUser.getName());
        }else {
            System.out.println("什么都没有"+ testUser == null);
        }
    }
}
