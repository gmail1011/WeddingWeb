package com.dongnao.weixinapp.service;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by 廖师兄
 * 2017-07-30 23:19
 */

//@ServerEndpoint("/webWeixinSocket")
@Slf4j
//@Service
public class WebWeixinSocket   {


    private Session session;

    private static CopyOnWriteArraySet<WebWeixinSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        System.out.println("--------添加消息");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }

    public void sendMessage(String message) {
        for (WebWeixinSocket webSocket: webSocketSet) {
            log.info("【websocket消息】广播消息, message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
//    CounterHandler counterHandler;
//
//    @Resource
//    private Session session;
//    private static CopyOnWriteArraySet<WebWeixinSocket> webWeixinSocketSet = new CopyOnWriteArraySet<>();
////
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
//        webWeixinSocketSet.add(this);
//    }
//
//    @OnClose
//    public void onClose() {
//        webWeixinSocketSet.remove(this);
//        log.info("【websocket消息】连接断开, 总数:{}", webWeixinSocketSet.size());
//    }
//
//    @OnMessage
//    public void onMessage(String message) {
//        log.info("【websocket消息】收到客户端发来的消息:{}", message);
//    }
//
//    public void sendMessage(String message) {
//        counterHandler.sendMessageToUser(message);
//    }
////    @Bean
////    public CounterHandler counterHandler() {
////        if (counterHandler == null) {
////            counterHandler = new CounterHandler();
////        }
////
////        return counterHandler;
////    }
////    @Override
////    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
////        //支持websocket 的 connection，指定counterHandler处理路径为/counter 的长连接请求
////        webSocketHandlerRegistry.addHandler(counterHandler(), "/webWeixinSocket")
////                //添加WebSocket握手请求的拦截器.
////                .addInterceptors(new CounterHandler.CountHandshakeInterceptor()).setAllowedOrigins("*");
////
//////        //不支持websocket的connenction,采用sockjs
////        webSocketHandlerRegistry.addHandler(counterHandler(), "/sockjs/webWeixinSocket")
////                //添加WebSocket握手请求的拦截器.
////                .addInterceptors(new CounterHandler.CountHandshakeInterceptor()).withSockJS();
////
////    }
//}
