package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController class for the endpoints of the lesson
 * API.
 */
@RestController
public class LessonController {

    private final LessonImpl lessonImpl;

    /**
     * @param lessonImpl
     */
    @Autowired
    public LessonController(LessonImpl lessonImpl) {
        this.lessonImpl = lessonImpl;
    }

    /**
     * With this endpoint we can add a new lesson.
     *
     * @param lesson
     */
    @PostMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Lesson createNewLesson(@RequestBody Lesson lesson) {
        return lessonImpl.save(lesson);
    }

    /**
     * with this endoint you can get all the lessons.
     *
     * @return a list of all the lessons.
     */
    @GetMapping(value = "/lesson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Lesson> getAllLessons() {
        return lessonImpl.findAll();
    }

}
