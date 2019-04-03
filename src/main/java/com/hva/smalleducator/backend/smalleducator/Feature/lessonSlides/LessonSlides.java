package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hva.smalleducator.backend.smalleducator.Feature.lesson.Lesson;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "LessonSlides")
public class LessonSlides {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "slide", nullable = false)
    @NotNull
    @NotBlank
    private String slide;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lesson Lesson;

}
