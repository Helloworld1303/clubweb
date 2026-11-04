package com.club.clubweb.activity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = true, length = 3000)
    private String content;
    @Column(nullable = false)
    private LocalDate activityDate;

    protected Activity() {
    }

    public Activity(String title, String content, LocalDate activityDate) {
        this.title = title;
        this.content = content;
        this.activityDate = activityDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void update(String title, String content, LocalDate activityDate) {
        this.title = title;
        this.content = content;
        this.activityDate = activityDate;
    }
}
