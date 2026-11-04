package com.club.clubweb.notice;

public class NoticeNotFoundException extends RuntimeException{

    public NoticeNotFoundException(long id){
        super(id + "번 공지사항을 찾을 수 없습니다.");
    }
}
