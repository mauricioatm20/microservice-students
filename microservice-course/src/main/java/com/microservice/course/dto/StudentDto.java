package com.microservice.course.dto;

import lombok.Data;

@Data
public class StudentDto {

    private String name;
    private String lastname;
    private String email;
    private String courseId;
}
