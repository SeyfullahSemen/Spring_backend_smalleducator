package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import java.util.List;


public interface ILessonSlideService {
    LessonSlides save(LessonSlides lessonSlides, Long lessonId);

    List<LessonSlides> findAll();
}
