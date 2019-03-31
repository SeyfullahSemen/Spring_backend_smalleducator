package com.hva.smalleducator.backend.smalleducator.Feature.lesson;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Lesson")
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "LONGTEXT")
    private String title;


}
