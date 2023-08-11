package com.student.projectstudent.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subject_name",nullable = false)
    private String name;
    @Column(name="subject_description",nullable = false)
    private String description ;
    @Column(name="subject_coeficient",nullable = false)
    private String coef;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Mark> marks;
    public Subject() {
    }

    public Subject(String coef,String name,String description) {
        this.coef = coef;
        this.name=name;
        this.description=description;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Mark marks) {
        this.marks.add(marks);
    }
}
