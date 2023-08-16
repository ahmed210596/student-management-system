package com.student.projectstudent.Service.impl;

import com.student.projectstudent.Entity.Student;
import com.student.projectstudent.Repository.StudentRepository;
import com.student.projectstudent.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl  implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
    public Long findStudentIdByFullName(String firstName, String lastName) {
        return studentRepository.findStudentIdByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Student> searchStudentByFullName(String fullname) {
        return studentRepository.searchStudentByFirstnameOrLastname(fullname);
    }
}
