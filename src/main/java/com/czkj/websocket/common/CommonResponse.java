package com.czkj.websocket.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 标准返回格式
 * @Author steven.sheng
 * @Date 2019/3/4/004.
 */
@Data
@AllArgsConstructor
public class CommonResponse<T> implements Serializable{
    private static final long serialVersionUID = 7124931832347815908L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息描述
     */
    private String msg;

    /**
     * 数据结果对象
     */
    private T data;

    public CommonResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonResponse success(){
        return new CommonResponse(CommonSuccessResult.SUCCESS, CommonSuccessResult.SUCCESS_MSG);
    }

    public static CommonResponse success(Object data){
        return new CommonResponse(CommonSuccessResult.SUCCESS, CommonSuccessResult.SUCCESS_MSG,data);
    }

    public static CommonResponse fail(Object data){
        return new CommonResponse(CommonSuccessResult.FAIL, CommonSuccessResult.FAIL_MSG,data);
    }

    public static CommonResponse fail(){
        return new CommonResponse(CommonSuccessResult.FAIL, CommonSuccessResult.FAIL_MSG);
    }

    public static CommonResponse fail(String msg){
        return new CommonResponse(CommonSuccessResult.FAIL,msg);
    }

    public static CommonResponse fail(Integer code , String msg){
        return new CommonResponse(code,msg);
    }
}
