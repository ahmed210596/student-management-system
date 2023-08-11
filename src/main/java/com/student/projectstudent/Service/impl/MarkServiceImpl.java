package com.student.projectstudent.Service.impl;

import com.student.projectstudent.Entity.Mark;
import com.student.projectstudent.Entity.Student;
import com.student.projectstudent.Entity.Subject;
import com.student.projectstudent.Repository.MarkRepository;
import com.student.projectstudent.Repository.StudentRepository;
import com.student.projectstudent.Repository.SubjectRepository;
import com.student.projectstudent.Service.MarkService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkRepository markRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    @Override
    @Transactional
    public void saveMark(Long studentId,Mark mark,Long subjectId) {
        // Retrieve the existing student from the database

        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        Subject existingSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        // Associate the existing student with the new mark

        System.out.println(mark.getMarkId());
        mark.setStudent(existingStudent);
        mark.setSubject(existingSubject);
        //existingStudent.setMarks(mark);
        //existingSubject.setMarks(mark);
        // Save the mark
        markRepository.save(mark);
    }

    @Override
    public Mark getMarkById(Long id) {
        return markRepository.findById(id).get();
    }

    @Override
    public Mark updateMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public void deleteMarkById(Long id) {
      markRepository.deleteById(id);
    }
}
