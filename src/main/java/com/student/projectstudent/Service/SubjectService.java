package com.student.projectstudent.Service;




import com.student.projectstudent.Entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAllSubjects();
    Subject saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    Subject updateSubject(Subject subject);

    void deleteSubjectById(Long id);
    Long findSubjectIdByName(String subjectName);
    List<Subject> searchSubjects(String keyword);
}
