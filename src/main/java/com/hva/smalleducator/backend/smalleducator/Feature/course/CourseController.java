package com.hva.smalleducator.backend.smalleducator.Feature.course;

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
public class CourseController {

    private final CourseImpl lessonImpl;

    /**
     * @param lessonImpl
     */
    @Autowired
    public CourseController(CourseImpl lessonImpl) {
        this.lessonImpl = lessonImpl;
    }

    /**
     * With this endpoint we can add a new course.
     *
     * @param course
     */
    @PostMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Course createNewLesson(@RequestBody Course course) {
        return lessonImpl.save(course);
    }

    /**
     * with this endoint you can get all the lessons.
     *
     * @return a list of all the lessons.
     */
    @GetMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Course> getAllLessons() {
        return lessonImpl.findAll();
    }

}
