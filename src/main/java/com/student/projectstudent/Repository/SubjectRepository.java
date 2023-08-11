package com.student.projectstudent.Repository;

import com.student.projectstudent.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    @Query("SELECT s.id FROM Subject s WHERE s.name = :subjectName")
    Long findSubjectIdByName(@Param("subjectName") String subjectName);
}
