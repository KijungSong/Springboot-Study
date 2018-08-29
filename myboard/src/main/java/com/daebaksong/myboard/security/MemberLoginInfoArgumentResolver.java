package com.daebaksong.myboard.security;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class MemberLoginInfoArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // methodParameter의 정보를 이용하여 파라미터 타입이 "MemberLoginInfo && @AuthUser" 인지를 검색해서 맞으면 true 리턴
        AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);
        if (authUser != null
            && parameter.getParameterType() == MemberLoginInfo.class) {
            return true;
        }
        return false;
    }

    // 위 메서드의 결과가 ture면 이 메서드가 실행
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //SecurityContextHolder를 이용하여 결과를 얻어서 리턴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object p = authentication.getPrincipal();
        if (p == null || p.getClass() == String.class) {
            return null;
        }

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        request.setAttribute("memberLoginInfo", p);
        return p;
    }
}
