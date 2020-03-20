package com.czkj.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ProjectName: websocket
 * @Package: com.czkj.websocket.config
 * @ClassName: WebSocketConfig
 * @Author: Administrator
 * @Description:
 * @Date 2019/11/22/02210:32
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
