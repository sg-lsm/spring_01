package org.lsm.spring01.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptionNumber(NumberFormatException numberFormatException){
        log.info("Number Exception Error... ");
        log.error(numberFormatException.getMessage());
        return "NUMBER FORMAT EXCEPTION";
    }
}
