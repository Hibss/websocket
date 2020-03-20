package com.czkj.websocket.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ProjectName: websocket
 * @Package: com.czkj.websocket.server
 * @ClassName: WebSocketServer
 * @Author: Administrator
 * @Description:
 * @Date 2019/11/22/02210:33
 */
@Component
@ServerEndpoint("/webSocket/{sid}")
@Slf4j
public class WebSocketServer {


    /**
     * 在线数量
     */
    private static Integer onlineCount = 0;

    /**
     * 线程安全set，用来存储每个客户端对应的WebSocket对象
     */
    private static CopyOnWriteArrayList<WebSocketServer> servers
            = new CopyOnWriteArrayList<>();

    /**
     * 与客户端联系的对话，发送数据到客户端
     */
    private Session session;

    private String sid = "";
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    /**
     * 建立连接
     * @param session
     * @param sid
     */
    @OnOpen
    public void open(Session session, @PathParam("sid")String sid){
        this.session = session;
        servers.add(this);
        addOnlineCount();
        log.info("新会话开始监听:{},在线人数:{}",sid,getOnlineCount());
        this.sid = sid;
        try{
            sendMessage("success");
        }catch(Exception e){
            log.error("连接出错:{}", ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * 断开连接
     */
    @OnClose
    public void onClose(){
        servers.remove(this);
        subOnlineCount();
        log.info("一个连接:{}退出，在线人数:{}",this.sid,getOnlineCount());
        log.info("服务数量：{}",servers.size());
    }

    /**
     * 收到消息后，进行处理
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        log.info("收到:{}的消息:{}",this.sid,message);
        servers.stream().forEach(server->{
            try{
                server.sendMessage(message);
            }catch(Exception e){
                log.error("发送消息出错:{}", ExceptionUtils.getStackTrace(e));
            }
        });
    }

    /**
     * 系统出错
     * @param session
     * @param e
     */
    @OnError
    public void onError(Session session,Throwable e){
        log.error("系统出错:{}",ExceptionUtils.getStackTrace(e));
    }

    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void batchSend(@PathParam("sid")String sid,String message){
        log.info("推送消息:{}到sid:{}",message,sid);
        servers.stream().forEach(server->{
            try{
                if(sid == null){
                    server.sendMessage(message);
                }else if(server.sid.equals(sid)){
                    server.sendMessage(message);
                }
            }catch (Exception e){
                log.info("批量发送消息出错:{}",ExceptionUtils.getStackTrace(e));
            }
        });
    }



}
