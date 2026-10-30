package com.club.clubweb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;



@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,length=100)
    private String title;
    @Column(nullable=false,length=3000)
    private String content;
    
    protected Notice(){}
    
    public Notice(String title, String content){
        this.title = title;
        this.content = content;
    }
    
    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
}
