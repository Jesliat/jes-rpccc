package com.jesliat.jesrpc.server;


import io.vertx.core.Vertx;


public class VertxHttpServer implements HttpServer {

    public void doStart(int port) {

        Vertx vertx = Vertx.vertx();

        //创建HTTP服务器
        io.vertx.core.http.HttpServer httpServer = vertx.createHttpServer();

//        //监听端口并处理请求
//        httpServer.requestHandler(req -> {
//            //处理HTTP请求
//            System.out.println("Request: " +req.method()+ " "+ req.uri());
//            //发送HTTP响应
//            req.response()
//                    .putHeader("content-type", "text/plain")
//                    .end("Hello from Vert.x server!");
//
//        });

        //监听端口并处理请求
        httpServer.requestHandler(new HttpServerHandler());


        //启动HTTP服务器并监听端口
        httpServer.listen(port, httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()) {
                System.out.println("Server started on port " + port);
            }else {
                System.out.println("Server failed to start on port " + httpServerAsyncResult.cause());
            }
        });
    };

}
