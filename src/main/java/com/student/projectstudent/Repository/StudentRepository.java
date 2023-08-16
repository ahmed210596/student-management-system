package com.student.projectstudent.Repository;

import com.student.projectstudent.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s.id FROM Student s WHERE s.firstname = :firstName AND s.lastname = :lastName")
    Long findStudentIdByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    @Query("SELECT s FROM Student s WHERE s.firstname LIKE %?1% OR s.lastname LIKE %?1%")
    List<Student> searchStudentByFirstnameOrLastname(String keyword);
}

