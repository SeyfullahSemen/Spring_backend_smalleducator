package com.hva.smalleducator.backend.smalleducator.Feature.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CourseImpl implements ICourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(@Valid Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public void delete(Course courseName) {
        courseRepository.delete(courseName);
    }

    @Override
    public Course findByName(String courseName) {
        return courseRepository.findByCoursename(courseName);
    }
}
