package com.nhfc99.test.exception;

public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private long code;
    private String errorMsg;

    public MyException(long code, String errorMsg) {
        super();
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
