package com.student.projectstudent.Service;

import com.student.projectstudent.Entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
    Long findStudentIdByFullName(String firstName, String lastName);
    List<Student>  searchStudentByFullName(String fullname);


}
