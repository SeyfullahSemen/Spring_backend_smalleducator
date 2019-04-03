package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import com.hva.smalleducator.backend.smalleducator.Feature.lesson.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class LessonSlideImpl implements ILessonSlideService {

    private final LessonSlideRepository lessonSlideRepository;

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonSlideImpl(LessonSlideRepository lessonSlideRepository, LessonRepository lessonRepository) {
        this.lessonSlideRepository = lessonSlideRepository;
        this.lessonRepository = lessonRepository;
    }


    @Override
    public LessonSlides save(@Valid LessonSlides lessonSlides, Long lessonId) {
        return lessonRepository.findById(lessonId).map(post -> {
            lessonSlides.setLesson(post);
            return lessonSlideRepository.save(lessonSlides);
        }).orElseThrow(() -> new ResourceNotFoundException("Id not found: " + lessonId));

    }

    @Override
    public List<LessonSlides> findAll() {
        return lessonSlideRepository.findAll();
    }
}
