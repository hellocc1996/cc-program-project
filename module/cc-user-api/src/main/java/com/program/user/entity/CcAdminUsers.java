package com.program.user.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CcAdminUsers implements Serializable {

    private long id;
    private String account;
    private String password;
    private String name;
    private long status;
    private long userType;
    private String lastLoginIp;
    private Date lastLoginTime;
    private long loginNum;
    private Date gmtCreate;
    private Date gmtModify;
    private long loginFailedTimes;
    private Date lastModifyPwdTime;
    private Date lastLoginFailTime;
    private List<CcAdminRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(long loginNum) {
        this.loginNum = loginNum;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public long getLoginFailedTimes() {
        return loginFailedTimes;
    }

    public void setLoginFailedTimes(long loginFailedTimes) {
        this.loginFailedTimes = loginFailedTimes;
    }

    public Date getLastModifyPwdTime() {
        return lastModifyPwdTime;
    }

    public void setLastModifyPwdTime(Date lastModifyPwdTime) {
        this.lastModifyPwdTime = lastModifyPwdTime;
    }

    public Date getLastLoginFailTime() {
        return lastLoginFailTime;
    }

    public void setLastLoginFailTime(Date lastLoginFailTime) {
        this.lastLoginFailTime = lastLoginFailTime;
    }

    public List<CcAdminRole> getRoles() {
        return roles;
    }

    public void setRoles(List<CcAdminRole> roles) {
        this.roles = roles;
    }
}
