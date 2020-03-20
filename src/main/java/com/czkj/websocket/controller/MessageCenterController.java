package com.czkj.websocket.controller;

import com.czkj.websocket.common.CommonResponse;
import com.czkj.websocket.server.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: websocket
 * @Package: com.czkj.websocket.controller
 * @ClassName: MessageCenterController
 * @Author: Administrator
 * @Description:
 * @Date 2019/11/22/02210:54
 */
@Controller
@RequestMapping("messageCenter")
@Slf4j
public class MessageCenterController {

    @RequestMapping("socket/{sid}")
    public String join(@PathVariable String sid,String message){
        try{
            Map<String,Object> map = new HashMap<>();
            map.put("message",message);
            return "socket";
//            ModelAndView modelAndView = new ModelAndView("/socket");
//            modelAndView.addObject("sid",sid);
//            return modelAndView;
        }catch (Exception e){
            log.error("系统错误:{}",ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    @GetMapping("socket/push/{sid}")
    @ResponseBody
    public CommonResponse push(@PathVariable String sid,String message){
        try{
            WebSocketServer.batchSend(sid,message);
        }catch (Exception e){
            log.error("推送数据接口出错:{}", ExceptionUtils.getStackTrace(e));
            return CommonResponse.fail(e.getMessage());
        }
        return CommonResponse.success();
    }
}
