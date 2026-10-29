package com.club.clubweb;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NoticeController {

    private final List<Notice> notices = List.of(
        new Notice(1, "10월 정기모임 안내", "10월 30일 저녁 7시에 모입니다."),
        new Notice(2, "MT 참가 신청", "11월 MT 참가 신청을 받습니다."),
        new Notice(3, "신입 부원 모집", "2학기 신입 부원을 모집합니다.")
    );

    @GetMapping("/api/notices")
    public List<Notice> getNotices() {
        return notices;
    }

    @GetMapping("/api/notices/{id}")
    public Notice getNotice(@PathVariable long id) {
        for (Notice notice : notices) {
            if (notice.getId() == id) {
                return notice;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}

