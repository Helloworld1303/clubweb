package com.club.clubweb.notice;

public record NoticeResponse (Long id, String title,String content){
    public static NoticeResponse from(Notice notice){
        return new NoticeResponse(notice.getId(),notice.getTitle(),notice.getContent());
    }
}
