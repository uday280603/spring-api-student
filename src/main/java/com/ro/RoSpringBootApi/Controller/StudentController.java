package com.ro.RoSpringBootApi.Controller;


import com.ro.RoSpringBootApi.Entity.Student;
import com.ro.RoSpringBootApi.Servivce.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService1) {
        this.studentService = studentService1;
    }


    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> getAllStudent = studentService.getAllStudent();
        return ResponseEntity.ok(getAllStudent);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student getStudent = studentService.getStudentById(id);
        if (getStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getStudent);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {

        Student updatedStudent = studentService.updateStudentInfo(id, student);
        if (updatedStudent == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(updatedStudent);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
         studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully...!");
    }

}
