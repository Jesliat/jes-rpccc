package com.jesliat.example.provider;

import com.jesliat.example.common.service.UserService;
import com.jesliat.jesrpc.registry.LocalRegistry;
import com.jesliat.jesrpc.server.HttpServer;
import com.jesliat.jesrpc.server.VertxHttpServer;

public class EasyProviderExample {
    public static void main(String[] args) {

        //注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        //启动WEB服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);

    }
}
