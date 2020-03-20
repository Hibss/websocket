package com.czkj.websocket.common;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author steven.sheng
 * @Date 2019/3/14/01415:33
 */
public class CommonConstants {

    public static final String PAY_LOCK_KEY = "ANSWER_CONTEST_PAY";
    public static final String MOBILE_LOCK_KEY = "ANSWER_CONTEST_MOBILE";
    public static final String GAME_COUNT_LOCK_KEY = "ANSWER_CONTEST_GAME_COUNT";
    public static final String LOTTERY_COUNT_LOCK_KEY = "ANSWER_CONTEST_LOTTERY_COUNT";
    public static final String LOTTERY_LOCK_KEY = "ANSWER_CONTEST_LOTTERY";
    public static final String QUESTION_LIST = "QUESTION_LIST";
    public static final Integer QUESTION_ROOKIE = 1;

    public static Integer SUCCESS = 0;

    public static Integer NO_FLAG = 0;
    public static Integer YES_FLAG = 1;
    public static Integer RECEIVED_FLAG = 1;

    /**
     * 默认邀请好友的昵称长度
     */
    public static Integer DEFAULT_FRIEND_NAME_LENGTH = 5;
    /**
     * 未答题的最大星数限制
     */
    public static Integer MAX_NO_ANSWER_STAR_COUNT = 10;

    /**
     * 默认页面设置
     */
    public static Integer DEFAULT_PAGE_SIZE = 7;
    public static Integer DEFAULT_PAGE_INDEX = 1;

    /**
     * 默认游戏次数
     */
    public static Integer DEFAULT_GAME_COUNT = 5;
    /**
     * 默认抽奖次数
     */
    public static Integer DEFAULT_LOTTERY_COUNT = 2;

    /**
     * 默认邀请好友奖励
     */
    public static Integer DEFAULT_INVITE_REWARD = 10;
    /**
     * 每日默认最大奖励星数
     */
    public static Integer DEFAULT_MAX_INVITE_REWARD = 100;

    /**
     * 邀请奖励界面超过邀请奖励星数的提示语句
     */
    public static String BEYOND_INVITE_REWARD_WARN = "已达当日奖励上限";


    /**
     * 随机红包总额
     */
    public static BigDecimal PAY_0 = new BigDecimal("49.5");
    public static BigDecimal PAY_1 = new BigDecimal("49");
    public static BigDecimal PAY_2 = new BigDecimal("48");

    public static Integer REDIS_USER_LAST_TIME = 30;
    public static TimeUnit REDIS_USER_LAST_TIME_UNIT = TimeUnit.MINUTES;

    public static Integer REDIS_MEDIA_ID_LAST_TIME = 71;
    public static TimeUnit REDIS_MEDIA_ID_LAST_TIME_UNIT = TimeUnit.HOURS;

    public static String QRCODE_SUFFIX = ".png";
    public static String CONNECTOR = "-";
    public static String USER_SCENE_FLAG = "ac2";


    public static String ACCESS_TOKEN = "answerContestAccessToken";

    public static String ADDRESS = "answerContestAddress";

    /**
     * 单个ip最大的用户数量
     */
    public static Integer MAX_IP_USER_COUNT = 300;
    /**
     * 用户每天获取的最大星数
     */
    public static Integer MAX_PER_DAY_STAR_COUNT = 200;
    /**
     * 活动截止时间
     */
    public static String DEAD_LINE = "NATIONAL_DAY_DEAD_LINE";
    /**
     * 用户缓存标记
     */
    public static String USER_REDIS = "answerContestUser";
    /**
     * 排名列表
     */
    public static String RANK_LIST = "answerContestRankList";
    /**
     * 号码中心业务名称
     */
    public static String SECURITY_SOURCE = "answer-contest";


    public static Integer REDIS_ROBOT_STRATEGY_LASTTIME = 1;
    public static TimeUnit REDIS_ROBOT_STRATEGY_TIME_UNIT = TimeUnit.HOURS;

    /**
     * 预警反馈内容最大长度
     */
    public static Integer FEEDBACK_CONTENT_MAX_LENGTH = 500;

    /**
     * 阈值上限值
     */
    public static Integer THRESHOLD_MAX_VALUE = 999999;

    /**
     * 阈值下限值
     */
    public static Integer THRESHOLD_MIN_VALUE = 0;

    /**
     * 规则名称最大长度
     * */
    public static Integer RULE_NAME_MAX_LENGTH=30;
}
