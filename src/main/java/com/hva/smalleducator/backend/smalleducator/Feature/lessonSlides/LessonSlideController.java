package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LessonSlideController {

    private final LessonSlideImpl lessonSlide;

    @Autowired
    public LessonSlideController(LessonSlideImpl lessonSlide) {
        this.lessonSlide = lessonSlide;
    }

    @PostMapping(value = "lesson/{lessonId}/lessonslide", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LessonSlides createNewSlide(LessonSlides lessonSlides, Long lessonId) {
        return lessonSlide.save(lessonSlides, lessonId);
    }

    @GetMapping(value = "/lessonslide", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<LessonSlides> getAllSlides() {
        return lessonSlide.findAll();
    }

}
