package com.club.clubweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/api/notices/1")
    public Notice getNotice() {
        return new Notice(1, "10월 정기모임 안내", "10월 30일 저녁 7시에 모입니다.");
    }
}