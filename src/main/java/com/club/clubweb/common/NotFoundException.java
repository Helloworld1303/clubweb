package com.club.clubweb.common;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
