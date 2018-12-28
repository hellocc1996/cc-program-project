package com.program.user.exception;

import java.io.Serializable;

public class CommonSysException extends RuntimeException implements Serializable {

    private ExpCodeEnum codeEnum;

    public CommonSysException(ExpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonSysException() {

    }
}
