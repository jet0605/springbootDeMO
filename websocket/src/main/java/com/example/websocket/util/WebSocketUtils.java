package com.example.websocket.util;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketUtils {
    /**
     * 模拟存储 websocket session使用
     */
    public static final Map<String,Session> LIVING_SESSIONS_CACHE = new ConcurrentHashMap<>();

    public static void sendMessageAll(String message){
        LIVING_SESSIONS_CACHE.forEach((sessionId, session) -> sendMessage(session,message));

    }
    public static void sendMessage(Session session,String message){
        if(session == null){
            return;
        }
        final RemoteEndpoint.Async async = session.getAsyncRemote();
        if(async == null){
            return;
        }
        async.sendText(message);
    }
}
