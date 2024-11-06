package com.microservice.course.service;


import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDto;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;


    @Override
    public List<Course> findByALL() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }


    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        //consultar el curso
        Course course = courseRepository.findById(idCourse).orElse(null);

        //obtener los estudiantes
        List<StudentDto> studentDtoList = studentClient.findAllStudentByCourseId(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDtoList(studentDtoList)
                .build();
    }
}
