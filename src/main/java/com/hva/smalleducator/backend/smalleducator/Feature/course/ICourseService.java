package com.hva.smalleducator.backend.smalleducator.Feature.course;

import java.util.List;

public interface ICourseService {
    Course save(Course course);

    List<Course> findAll();

    void delete(Course courseName);

    Course findByName(String courseName);
}
