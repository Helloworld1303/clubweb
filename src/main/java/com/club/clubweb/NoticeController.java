package com.club.clubweb;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/api/notices")
    public List<Notice> getNotices() {
        return noticeService.findAll();
    }

    @GetMapping("/api/notices/{id}")
    public Notice getNotice(@PathVariable long id) {
        return noticeService.findById(id);
    }

    @PostMapping("/api/notices")
    @ResponseStatus(HttpStatus.CREATED)
    public Notice createNotice(@Valid @RequestBody NoticeCreateRequest request) {
        return noticeService.create(request.title(), request.content());
    }

    @PutMapping("/api/notices/{id}")
    public Notice updateNotice(@PathVariable long id, @Valid @RequestBody NoticeCreateRequest request) {
        return noticeService.update(id, request.title(), request.content());
    }

    @DeleteMapping("/api/notices/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNotice(@PathVariable long id) {
        noticeService.delete(id);
    }

    @GetMapping("/api/notice-count")
    public long getNoticeCount() {
        return noticeService.count();
    }
}