package com.club.clubweb.notice;

import java.util.ArrayList;
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
    public List<NoticeResponse> getNotices() {
        List<NoticeResponse> responses=new ArrayList<>();
        for (Notice notice : noticeService.findAll()){
            responses.add(NoticeResponse.from(notice));
        }
        return responses;
    }

    @GetMapping("/api/notices/{id}")
    public NoticeResponse getNotice(@PathVariable long id) {
        Notice notice = noticeService.findById(id);
        return NoticeResponse.from(notice);
    }

    @PostMapping("/api/notices")
    @ResponseStatus(HttpStatus.CREATED)
    public NoticeResponse createNotice(@Valid @RequestBody NoticeRequest request) {
        Notice notice = noticeService.create(request.title(),request.content());
        return NoticeResponse.from(notice);
    }

   
    @PutMapping("/api/notices/{id}")
    public NoticeResponse updateNotice(@PathVariable long id, @Valid @RequestBody NoticeRequest request){
        Notice notice = noticeService.update(id,request.title(),request.content());
        return NoticeResponse.from(notice);
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