package com.daebaksong.myshop.config;

import com.daebaksong.myshop.utils.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // java config 클래스는 해당 애노테이션이 붙어 있어야 한다.!
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 사용자가 작성한 인터셉터를 추가한다.
        registry.addInterceptor(new LogInterceptor());
    }
}
