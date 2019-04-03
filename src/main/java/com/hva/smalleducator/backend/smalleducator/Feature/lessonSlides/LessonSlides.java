package com.hva.smalleducator.backend.smalleducator.Feature.lessonSlides;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hva.smalleducator.backend.smalleducator.Feature.lesson.Lesson;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "LessonSlides")
public class LessonSlides implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "slide", nullable = false)
    @NotNull
    @NotBlank
    private String slide;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Lesson Lesson;

}
