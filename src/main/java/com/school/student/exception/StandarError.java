package com.school.student.exception;

import java.io.Serializable;
import java.time.Instant;

public class StandarError implements Serializable {
    private static final long serialVersionUDI=1l;

    private Instant timeTamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandarError() {
    }

    public Instant getTimeTamp() {
        return timeTamp;
    }

    public void setTimeTamp(Instant timeTamp) {
        this.timeTamp = timeTamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
