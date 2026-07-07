package com.ro.RoSpringBootApi.Servivce;

import com.ro.RoSpringBootApi.Entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student updateStudentInfo(Long id , Student student);
    void  deleteStudent(Long id);
}
