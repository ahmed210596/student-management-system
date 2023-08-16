package com.student.projectstudent.Entity;

import com.student.projectstudent.Entity.Student;
import com.student.projectstudent.Entity.Subject;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Marks")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private int marksObtained;
    private LocalDate examDate;

    public Mark() {

    }

    public Mark( int marksObtained,LocalDate examDate) {


        this.marksObtained = marksObtained;
        this.examDate= examDate;
    }

    //public Long getMarkId() {
       // return id;
    //}

    //public void setMarkId(Long markId) {
       // this.id = markId;
    //}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}
