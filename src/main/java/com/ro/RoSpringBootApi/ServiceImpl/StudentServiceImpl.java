package com.ro.RoSpringBootApi.ServiceImpl;

import com.ro.RoSpringBootApi.Entity.Student;
import com.ro.RoSpringBootApi.Repository.StudentRepository;
import com.ro.RoSpringBootApi.Servivce.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {



    private final StudentRepository studentRepository;

    public StudentServiceImpl (StudentRepository studentRepository1){
        this.studentRepository=studentRepository1;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudentInfo(Long id, Student student) {
       Student existingStudent = studentRepository.findById(id).orElse(null);
       if (existingStudent == null){
           return  null;
       }
       existingStudent.setStudent_name(student.getStudent_name());
       existingStudent.setStudent_email(student.getStudent_email());
       existingStudent.setStudent_phone(student.getStudent_phone());
       existingStudent.setStudent_address(student.getStudent_address());
       existingStudent.setStudent_std(student.getStudent_std());

       return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student getDeleteStudent = studentRepository.findById(id).orElse(null);
        if (getDeleteStudent == null){
            throw  new RuntimeException("Student with id "+id+" is not found..!");
        }
        studentRepository.deleteById(id);

    }
}
