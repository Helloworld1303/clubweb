package com.club.clubweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notice {

    @Id
    private long id;
    @Column(nullable=false,length=100)
    private String title;
    @Column(nullable=false,length=3000)
    private String content;
    
    protected Notice(){}
    
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