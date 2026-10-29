package com.club.clubweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class Notice {
    private long id;
    private String title;
    private String content;
    
    public Notice(long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    
    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}