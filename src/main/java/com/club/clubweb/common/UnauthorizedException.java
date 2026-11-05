package com.club.clubweb.common;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){
        super("관리자 키가 올바르지 않습니다.");
    }
}
