package com.club.clubweb;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        Optional<Notice> result = noticeRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return result.get();
    }

    @GetMapping("/api/notice-count")
    public int getNoticeCount(){
        return noticeRepository.findAll().size();
    }
    @PostMapping("/api/notices")
    @ResponseStatus(HttpStatus.CREATED)
    public Notice createNotice(@RequestBody NoticeCreateRequest request){
        Notice notice = new Notice(request.title(),request.content());
        return noticeRepository.save(notice);
    }
}
