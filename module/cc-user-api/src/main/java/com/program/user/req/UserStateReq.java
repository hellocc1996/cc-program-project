package com.program.user.req;

public class UserStateReq extends AbsReq {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户状态
     */
    private int userState;

    public UserStateReq(String userId, int userState) {
        this.userId = userId;
        this.userState = userState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}
