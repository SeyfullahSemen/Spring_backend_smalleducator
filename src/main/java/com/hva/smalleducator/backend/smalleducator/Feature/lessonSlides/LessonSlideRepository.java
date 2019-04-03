package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonSlideRepository extends CrudRepository<LessonSlides, Long> {
    @Override
    List<LessonSlides> findAll();
}
