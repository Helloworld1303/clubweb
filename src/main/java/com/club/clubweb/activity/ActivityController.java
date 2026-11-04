package com.club.clubweb.activity;

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
import java.util.ArrayList;

import jakarta.validation.Valid;

@RestController
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/api/activities")
    public List<ActivityResponse> getActivities() {
        List<ActivityResponse> responses = new ArrayList<>();
        for (Activity activity : activityService.findAll()) {
            responses.add(ActivityResponse.from(activity));
        }
        return responses;
    }

    @GetMapping("/api/activities/{id}")
    public ActivityResponse getActivity(@PathVariable long id) {
        Activity activity = activityService.findById(id);
        return ActivityResponse.from(activity);
    }

    @PostMapping("/api/activities")
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityResponse createActivity(@Valid @RequestBody ActivityRequest request) {
        Activity activity = activityService.create(request.title(), request.content(), request.activityDate());
        return ActivityResponse.from(activity);
    }

    @PutMapping("/api/activities/{id}")
    public ActivityResponse updateActivity(@PathVariable long id, @Valid @RequestBody ActivityRequest request) {
        Activity activity = activityService.update(id, request.title(), request.content(), request.activityDate());
        return ActivityResponse.from(activity);
    }

    @DeleteMapping("/api/activities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity(@PathVariable long id) {
        activityService.delete(id);
    }

}
