package com.daebaksong.myboard.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
@Order(2) //@ControllerAdvice가 여러개일 경우 우선순위 낮을수록 우선순위 높음
public class GlobalControllerExceptionHandler {

    // 예외 별로 메서드를 만들어서 처리가능하며 redirect 설정도 가능.
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return "exceptions/exception"; //view 만들어야한다.
    }
}
