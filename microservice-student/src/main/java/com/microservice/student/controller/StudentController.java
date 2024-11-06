package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(student);
    }


//    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveStudent(@RequestBody Student student){
//        studentService.save(student);
//    }


    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return  ResponseEntity.ok(studentService.findById(id));
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search-ny-course/{idCourse}")
    public ResponseEntity<?> findAllByCourseId(@PathVariable Long idCourse) {
        return ResponseEntity.ok(studentService.findAllByCourseId(idCourse));
    }
}
