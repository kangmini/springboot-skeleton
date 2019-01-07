package io.company.app.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{

    int status = 400;
    String errorCode = "9999";

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public BaseException(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public BaseException(int status, String errorCode, String msg) {
        super(msg);
        this.status = status;
        this.errorCode = errorCode;
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public BaseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
