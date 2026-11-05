package com.club.clubweb.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AdminKeyInterceptor implements HandlerInterceptor{
    private final String adminKey;

    public AdminKeyInterceptor(@Value("${admin.key}") String adminKey){
        this.adminKey = adminKey;
    }
    @Override 
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if (request.getMethod().equals("GET")){
            return true;
        }
        String key = request.getHeader("X-Admin-Key");
        if(key==null || !key.equals(adminKey)){
            throw new UnauthorizedException();
        }
        return true;
    }
}
