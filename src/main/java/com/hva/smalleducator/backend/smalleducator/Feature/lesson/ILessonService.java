package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import java.util.List;

public interface ILessonService {
    Lesson save(Lesson lesson);

    List<Lesson> findAll();
}
