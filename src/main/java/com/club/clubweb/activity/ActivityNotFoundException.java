package com.club.clubweb.activity;

import com.club.clubweb.common.NotFoundException;

public class ActivityNotFoundException extends NotFoundException{
    public ActivityNotFoundException(long id){
        super(id+"번 활동기록을 찾을 수 없습니다.");
    }    
}
