package com.czkj.websocket.common;

/**
 * 失败结果
 * @Author steven.sheng
 * @Date 2019/3/4/004.
 */
public class CommonFailResult {

    public static Integer NO_AUTHORIZED = -10001;
    public static String NO_AUTHORIZED_MSG = "登录失效";

    public static Integer DECRYPT_ERROR = -10003;
    public static String DECRYPT_ERROR_MSG = "用户号码信息解密失败";

    public static Integer NO_MONEY = -10008;
    public static String NO_MONEY_MSG = "红包已经领完";

    public static Integer MOBILE_AUTH = -10004;
    public static String MOBILE_AUTH_MSG = "手机号码未授权";

    public static Integer NULL_PARAMS = -10005;
    public static String NULL_PARAMS_MSG = "输入参数不可为空";

    public static Integer MOBILE_REGEX_ERROR = -10006;
    public static String MOBILE_REGEX_ERROR_MSG = "手机号码不符合规则";


    public static Integer QR_CODE_IMG_ERROR = -10010;
    public static String QR_CODE_IMG_ERROR_MSG = "二维码生成出错";

    public static Integer PAY_TIME_ERROR = -100041;
    public static String PAY_TIME_ERROR_MSG = "领取红包时间不符合规则";

    public static Integer LOTTERY_CONFIG = -100042;
    public static String LOTTERY_CONFIG_MSG = "无对应的红包类型";

    public static Integer USER_STAR_ERROR = -100043;
    public static String USER_STAR_ERROR_MSG = "用户无对应类型红包的资格";
}
