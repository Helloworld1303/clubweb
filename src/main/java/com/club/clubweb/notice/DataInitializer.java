package com.club.clubweb.notice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("local")
public class DataInitializer implements CommandLineRunner{

    private final NoticeRepository noticeRepository;

    public DataInitializer(NoticeRepository noticeRepository){
        this.noticeRepository=noticeRepository;
    }

    @Override
    public void run(String... args){
        if(noticeRepository.count()==0){
            noticeRepository.save(new Notice("10월 정기모임 안내","10월 30일 저녁 7시에 모입니다."));
            noticeRepository.save(new Notice("MT 참가 신청","11월 MT 참가 신청을 받습니다."));
            noticeRepository.save(new Notice("신입 부원 모집","2학기 신입 부원을 모집합니다."));
        }
    }
}

