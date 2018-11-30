package com.program.admin.dto.resp;

import java.io.Serializable;

public class AjaxResult implements Serializable {

    private static final long serialVersionUID = 2070529321927253144L;

    private boolean isSuccess;

    private String errInfo;

    private Object result;

    public AjaxResult() {
    }

    public AjaxResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
