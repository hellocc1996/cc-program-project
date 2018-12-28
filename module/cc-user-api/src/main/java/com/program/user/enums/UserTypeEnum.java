package com.program.user.enums;

public enum UserTypeEnum implements BaseEnum {
    Person(1, "个人用户"),
    Company(2, "企业用户"),
    ADMIN(3, "管理员");

    private int code;
    private String msg;

    UserTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取枚举
     *
     * @param code
     * @return
     */
    public static UserTypeEnum getEnumByCode(int code) {
        for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {
            if (userTypeEnum.getCode() == code) {
                return userTypeEnum;
            }
        }

        return null;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
