package com.czkj.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ProjectName: websocket
 * @Package: com.czkj.websocket.controller
 * @ClassName: HelloController
 * @Author: Administrator
 * @Description:
 * @Date 2019/11/22/02211:29
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("view")
    public String helloView(Map<String,Object> map){
        map.put("hello","中午吃啥啊");
        return "hello";
    }
}
