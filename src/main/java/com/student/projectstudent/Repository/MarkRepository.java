package com.student.projectstudent.Repository;

import com.student.projectstudent.Entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarkRepository extends JpaRepository<Mark,Long> {
}
