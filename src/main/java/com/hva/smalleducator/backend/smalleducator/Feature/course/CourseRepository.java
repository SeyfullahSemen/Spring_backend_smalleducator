package com.hva.smalleducator.backend.smalleducator.Feature.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    @Override
    List<Course> findAll();
}
