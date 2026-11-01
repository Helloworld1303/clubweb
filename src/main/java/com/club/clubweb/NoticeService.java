package com.club.clubweb;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NoticeService {
    
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository){
        this.noticeRepository=noticeRepository;
    }
    public List<Notice> findAll() {
        return noticeRepository.findAll();
    }

    public Notice findById(long id){
        Optional<Notice> result = noticeRepository.findById(id);
        if(result.isEmpty()){
            throw new NoticeNotFoundException(id);
        }
        return result.get();
    }
    
    public Notice create(String title, String content){
        return noticeRepository.save(new Notice(title,content));
    }

    public Notice update(long id,String title, String content){
        Notice notice = findById(id);
        notice.update(title,content);
        return noticeRepository.save(notice);
    }
    public void delete(long id){
        Notice notice=findById(id);
        noticeRepository.delete(notice);
    }

    public long count(){
        return noticeRepository.count();
    }
}

