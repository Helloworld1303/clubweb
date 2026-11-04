package com.club.clubweb.activity;

import java.time.LocalDate;

public record ActivityResponse(Long id, String title, String content, LocalDate activityDate) {
    public static ActivityResponse from(Activity activity) {
        return new ActivityResponse(activity.getId(), activity.getTitle(), activity.getContent(),
                activity.getActivityDate());
    }
}
