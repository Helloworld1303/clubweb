package com.club.clubweb.notice;
import com.club.clubweb.common.NotFoundException;

public class NoticeNotFoundException extends NotFoundException{
    public NoticeNotFoundException(long id){
        super(id + "번 공지사항을 찾을 수 없습니다.");
    }
}
