package com.program.user.exception;


import java.io.Serializable;

import static com.program.util.exception.ExpPrefixUtil.*;

public enum ExpCodeEnum implements Serializable {

    /**
     * 通用异常
     */
    UNKNOW_ERROR(ComExpPrefix + "000", "未知异常"),
    ERROR_404(ComExpPrefix + "001", "没有该接口"),
    PARAM_NULL(ComExpPrefix + "002", "参数为空"),
    NO_REPEAT(ComExpPrefix + "003", "请勿重复提交"),
    SESSION_NULL(ComExpPrefix + "004", "请求头中SessionId不存在"),
    HTTP_REQ_METHOD_ERROR(ComExpPrefix + "005", "HTTP请求方法不正确"),
    JSONERROR(ComExpPrefix + "006", "JSON解析异常"),

    /**
     * User模块异常
     */
    USERNAME_NULL(UserExpPrefix + "000", "用户名为空"),
    PASSWD_NULL(UserExpPrefix + "001", "密码为空"),
    AUTH_NULL(UserExpPrefix + "002", "手机、电子邮件、用户名 至少填一个"),
    LOGIN_FAIL(UserExpPrefix + "003", "登录失败"),
    UNLOGIN(UserExpPrefix + "004", "尚未登录"),
    NO_PERMISSION(UserExpPrefix + "005", "没有权限"),
    PHONE_NULL(UserExpPrefix + "006", "手机号为空"),
    MAIL_NULL(UserExpPrefix + "007", "电子邮件为空"),
    USERTYPE_NULL(UserExpPrefix + "008", "用户类别为空"),
    LICENCE_NULL(UserExpPrefix + "009", "营业执照为空"),
    COMPANYNAME_NULL(UserExpPrefix + "010", "企业名称为空"),
    ROLE_NULL(UserExpPrefix + "011", "角色为空"),
    ROLEID_NULL(UserExpPrefix + "012", "roleId为空"),
    MENUIDLIST_NULL(UserExpPrefix + "013", "menuIdList为空"),
    PERMISSIONIDLIST_NULL(UserExpPrefix + "014", "permissionIdList为空"),
    NAME_NULL(UserExpPrefix + "015", "name为空"),
    LOCATIONID_NULL(UserExpPrefix + "016", "locationId为空"),
    LOCATIONUPDATEREQ_NULL(UserExpPrefix + "017", "LocationUpdateReq为空"),
    USERID_NULL(UserExpPrefix + "018", "UserId为空"),
    LOCATION_NULL(UserExpPrefix + "019", "地址为空");


    private String code;
    private String message;

    private ExpCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ExpCodeEnum() {
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
