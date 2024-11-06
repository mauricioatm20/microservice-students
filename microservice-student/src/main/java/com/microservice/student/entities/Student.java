package com.microservice.student.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastname;
    private String email;

    @Column(name = "course_id")
    private Long courseId;
}
