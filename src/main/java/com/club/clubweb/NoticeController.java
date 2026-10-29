package com.club.clubweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/api/notices/{id}")
    public Notice getNotice(@PathVariable long id) {
        return new Notice(id,id+"번 공지사항","내용입니다.");
    }
}