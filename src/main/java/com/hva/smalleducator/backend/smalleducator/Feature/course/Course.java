package com.hva.smalleducator.backend.smalleducator.Feature.course;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This is the entity class
 * to create new schema.
 */
@Entity
@Table(name = "Course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "coursename", nullable = false)
    @NotBlank
    @NotNull
    public String coursename;
}
