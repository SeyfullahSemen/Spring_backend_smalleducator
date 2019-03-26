package com.hva.smalleducator.backend.smalleducator.Feature;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This is the entity class
 * to create new schema.
 */
@Entity
@Table(name = "lesson")
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "lessonname", nullable = false)
    @NotBlank
    @NotNull
    public String lessonname;
}
