package com.student.projectstudent.Service.impl;

import com.student.projectstudent.Entity.Subject;
import com.student.projectstudent.Repository.SubjectRepository;
import com.student.projectstudent.Service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubjectById(Long id) {
    subjectRepository.deleteById(id);
    }
    public Long findSubjectIdByName(String subjectName) {
        return subjectRepository.findSubjectIdByName(subjectName);
    }
}
