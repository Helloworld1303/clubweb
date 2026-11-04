package com.club.clubweb.activity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity findById(long id) {
        Optional<Activity> result = activityRepository.findById(id);
        if (result.isEmpty()) {
            throw new ActivityNotFoundException(id);
        }
        return result.get();
    }

    @Transactional
    public Activity create(String title, String content, LocalDate activityDate) {
        return activityRepository.save(new Activity(title, content, activityDate));
    }

    @Transactional
    public Activity update(long id, String title, String content, LocalDate activityDate) {
        Activity activity = findById(id);
        activity.update(title, content, activityDate);
        return activity;
    }

    @Transactional
    public void delete(long id) {
        Activity activity = findById(id);
        activityRepository.delete(activity);
    }

}
