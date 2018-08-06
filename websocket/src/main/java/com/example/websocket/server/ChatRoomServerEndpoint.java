package com.example.websocket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import static com.example.websocket.util.WebSocketUtils.LIVING_SESSIONS_CACHE;
import static com.example.websocket.util.WebSocketUtils.sendMessage;
import static com.example.websocket.util.WebSocketUtils.sendMessageAll;

/**
 * 聊天室
 * @author Jet
 */
@RestController
@ServerEndpoint("/chat-room/{username}") //websocket协议地址
public class ChatRoomServerEndpoint {
    private static final Logger log = LoggerFactory.getLogger(ChatRoomServerEndpoint.class);

    @OnOpen
    public void openSession(@PathParam("username") String username,Session session){
        LIVING_SESSIONS_CACHE.put(username,session);
        String message = "欢迎用户[" + username + "]来到聊天室！";
        log.info(message);
        sendMessage(session,message);
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username,String message){
        log.info(message);
        sendMessageAll("用户[" + username + "] :" + message);
    }

    @OnError
    public void onError(Session session,Throwable throwable){
        try{
            session.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        throwable.printStackTrace();
    }

    @GetMapping("/chat-room/{sender}/to/{receive}")
    public void onMessage(@PathVariable("sender") String sender,@PathVariable("receive") String receive,String message){
            //@PathVariable注解绑定它传过来的值到方法参数上
            //用于将请求的URL中的模板变量绑定它传过来的值的方法参数上，及取出URL模板中的变量作为参数
            sendMessage(LIVING_SESSIONS_CACHE.get(receive),"[" + sender + "]" + "->[" + receive + "] :" + message);
    }
}
