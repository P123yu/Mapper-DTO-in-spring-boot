package com.holiday.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

@Data
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ResponseUtil<T>{

    private int status;
    private Boolean success = true;
    private String message;
    private T data;
    private Object error;


    public ResponseUtil(int status, Boolean success, String message) {
        this.status = status;
        this.success = success;
        this.message = message;
    }

    public ResponseUtil(int status, Boolean success, String message, T data) {
        this.status = status;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseUtil(int status, Boolean success, String message, T data, Object error) {
        this.status = status;
        this.success = success;
        this.message = message;
        this.data = data;
        if (error != null) {
            this.error = error;
        }
    }

    void setSuccessResponse(T data, String message) {
        this.message = message;
        this.data = data;
        this.success = true;
    }

    void setErrorResponse(Throwable e, String message) {
        this.message = StringUtils.isEmpty(message) ? e.getMessage() : message;
        this.success = false;
    }

    public void setFailureResponse(String message) {
        this.message = message;
        this.success = false;
    }

}
