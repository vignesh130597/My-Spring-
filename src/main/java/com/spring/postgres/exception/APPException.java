package com.spring.postgres.exception;

import org.springframework.http.HttpStatus;

public class APPException extends RuntimeException {

    HttpStatus httpStatus;

    public APPException() {
        super();
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public APPException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public APPException(Throwable cause) {
        super(cause);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public APPException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public APPException(String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public APPException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
