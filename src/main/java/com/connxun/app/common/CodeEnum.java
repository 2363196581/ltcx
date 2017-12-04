package com.connxun.app.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author：luoxiaosheng
 * @Date：2017-11-11 17:14
 * @Description：基础状态码枚举
 */

@AllArgsConstructor
public enum CodeEnum {



    //通用
    SUCCESS("200", "获取成功"),
    NOHTTP("201", "您的网络状况存在问题，调用服务失败！"),
    FAIL("1001", "获取信息失败"),
    PARAMFAIL("1002", "参数为空或所传参数类型不正确"),

    //用户   100-199
    USERISNOT("101", "用户不存在"),
    LOGINFAIL("102", "您的密码错误!"),
    CAPTCHFAIL("103", "验证码错误"),
    TOKENFAIL("104", "token验证失败"),
    AUDITFAIL("105", "禁用"),
    AUDITING("106", "审核中"),
    SESSIONFAIL("107", "session失效"),
    PHONEREPEAT("108", "您的手机号已被注册"),
    PHONEFAIL("109", "您的手机号还没有注册"),
    OPENLOGIN("110", "请完善个人信息"),
    ISBLACK("113", "已加入黑名单"),
    NOBLACK("114", "未加入黑名单"),
    NOADDRESS("117", "地址参数错误"),


    // 其他1000-1099
    NEWVERSION("1001", "最新版本"),
    NOVERSION("1002", "请更新版本");

    @Getter @Setter
    private String code;
    @Getter @Setter
    private String message;


}
