package com.hva.smalleducator.backend.smalleducator.Feature;

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

    private final LessonRepository lessonRepository;

    /**
     * @param lessonRepository
     */
    @Autowired
    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    /**
     * With this endpoint we can add a new lesson.
     * @param lesson
     */
    @PostMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void createNewLesson(@RequestBody Lesson lesson) {
        lessonRepository.save(lesson);
    }

    /**
     * with this endoint you can get all the lessons.
     * @return
     */
    @GetMapping(value = "/lesson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

}
