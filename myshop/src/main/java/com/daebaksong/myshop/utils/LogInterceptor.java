package com.daebaksong.myshop.utils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // request.setAttribute("startTime", System.nanoTime());
        LogContext.time.set(System.nanoTime());

        System.out.println("preHandle: "+ handler);
        return true; // false를 리턴하면 문제가 생겼다는것으로 판단하고 controller실행하지 않고 종료된다.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //long startTime = (long) request.getAttribute("startTime");
        long startTime = LogContext.time.get();
        long diffTime = System.nanoTime() - startTime;

        System.out.println("postHandle: "+ handler + " : " + "걸린시간:"+diffTime);
    }
}
