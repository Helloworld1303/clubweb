package com.club.clubweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoticeRepository {

    private final List<Notice> notices = new ArrayList<>();

    public NoticeRepository() {
        notices.add(new Notice(1, "10월 정기모임 안내", "10월 30일 저녁 7시에 모입니다."));
        notices.add(new Notice(2, "MT 참가 신청", "11월 MT 참가 신청을 받습니다."));
        notices.add(new Notice(3, "신입 부원 모집", "2학기 신입 부원을 모집합니다."));
    }

    public List<Notice> findAll() {
        return notices;
    }

    public Notice findById(long id) {
        for (Notice notice : notices) {
            if (notice.getId() == id) {
                return notice;
            }
        }
        return null;
    }
}