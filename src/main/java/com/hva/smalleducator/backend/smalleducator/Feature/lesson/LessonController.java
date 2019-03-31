package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LessonController {
    private final LessonImpl lessonImpl;

    @Autowired
    public LessonController(LessonImpl lessonImpl) {
        this.lessonImpl = lessonImpl;
    }

    @PostMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Lesson createNewLesson(@Valid Lesson lesson) {
        return lessonImpl.save(lesson);
    }
}
