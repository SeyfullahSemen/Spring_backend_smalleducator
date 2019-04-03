package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
     * @param lesson
     * @return the saved lesson
     */
    @PostMapping(value = "/lesson", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson createNewLesson(@Valid @RequestBody Lesson lesson) {
        return lessonImpl.save(lesson);
    }

    /**
     * @return All the persisted lessons
     */
    @GetMapping(value = "/lesson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Lesson> getAllLessons() {
        return lessonImpl.findAll();
    }

}
