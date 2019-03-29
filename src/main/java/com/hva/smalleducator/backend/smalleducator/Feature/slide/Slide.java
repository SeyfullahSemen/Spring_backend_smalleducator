package com.hva.smalleducator.backend.smalleducator.Feature.slide;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "slide")
@Entity
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, columnDefinition = "LONGTEXT")
    private String title;

}
