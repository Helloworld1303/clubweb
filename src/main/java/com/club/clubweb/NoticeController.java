package com.club.clubweb;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class NoticeController {

    private final NoticeRepository noticeRepository;

    public NoticeController(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @GetMapping("/api/notices")
    public List<Notice> getNotices() {
        return noticeRepository.findAll();
    }

    @GetMapping("/api/notices/{id}")
    public Notice getNotice(@PathVariable long id) {
        Notice notice = noticeRepository.findById(id);
        if (notice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return notice;
    }

    @GetMapping("/api/notice-count")
    public int getNoticeCount(){
        return noticeRepository.findAll().size();
    }
}
