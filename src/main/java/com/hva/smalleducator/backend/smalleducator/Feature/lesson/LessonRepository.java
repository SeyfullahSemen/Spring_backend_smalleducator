package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {
    @Override
    List<Lesson> findAll();
}
