
package com.holiday.exception;
import com.holiday.util.ResponseUtil;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Builder
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseUtil<Object> handleJsonParseException(HttpMessageNotReadableException ex) {
        ResponseUtil<Object> response = ResponseUtil.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .success(false)
                .message("validation.invalid.payload")
                .error(ex.getMessage())
                .build();
        return response;

        //return new ResponseUtil<>(HttpStatus.BAD_REQUEST.value(), false,  "validation.invalid.payload" , null, ex.getMessage());

    }


    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseUtil<Object> handleResourceNotFoundException(NoResourceFoundException ex) {
        ResponseUtil<Object> response= ResponseUtil.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .success(false)
                .message("resource.not.found")
                .error(ex.getMessage())
                .build();
        return response;

//        return new ResponseUtil<>(HttpStatus.NOT_FOUND.value(), false, "resource.not.found", null, ex.getMessage());
    }

}

