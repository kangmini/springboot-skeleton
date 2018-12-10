package io.company.app.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{

    int status = 500;

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public BaseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
