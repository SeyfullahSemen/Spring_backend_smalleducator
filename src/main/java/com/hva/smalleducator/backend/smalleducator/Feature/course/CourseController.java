package com.hva.smalleducator.backend.smalleducator.Feature.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * RestController class for the endpoints of the lesson
 * API.
 */
@RestController
public class CourseController {

    private final CourseImpl courseImpl;

    /**
     * @param courseImpl
     */
    @Autowired
    public CourseController(CourseImpl courseImpl) {
        this.courseImpl = courseImpl;
    }

    /**
     * With this endpoint we can add a new course.
     *
     * @param course
     */
    @PostMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Course createNewLesson(@Valid @RequestBody Course course) {
        return courseImpl.save(course);
    }

    /**
     * with this endoint you can get all the lessons.
     *
     * @return a list of all the courses.
     */
    @GetMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Course> getAllLessons() {
        return courseImpl.findAll();
    }

    /**
     * Delete the given coursename from the database
     *
     * @param courseName
     */
    @DeleteMapping(value = "/course/{courseName}")
    @ResponseStatus(HttpStatus.FOUND)
    public void deleteCourse(@PathVariable(value = "courseName") Course courseName) {
        courseImpl.delete(courseName);
    }
}
