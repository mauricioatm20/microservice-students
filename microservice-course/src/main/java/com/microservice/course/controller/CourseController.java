package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    public ResponseEntity<Course> saveStudent(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents() {
        return ResponseEntity.ok(courseService.findByALL());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
    }
}
