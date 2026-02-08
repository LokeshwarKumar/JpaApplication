package com.learn.JpaApplication.model;

import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@NoArgsConstructor
@Entity
public class Author {

    
    /*  @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "author_sequence"
    )
    @SequenceGenerator(
        name="author_sequence",
        sequenceName = "author_sequence",
        allocationSize = 1
    ) */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;
}
