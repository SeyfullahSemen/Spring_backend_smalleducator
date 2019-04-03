package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "LONGTEXT")
    @NotBlank
    @NotNull
    private String title;


}
