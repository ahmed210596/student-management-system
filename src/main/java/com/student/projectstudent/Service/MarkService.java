package com.student.projectstudent.Service;





import com.student.projectstudent.Entity.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> getAllMarks();
    void saveMark(Long studentId,Mark mark,Long subjectId);

    Mark getMarkById(Long id);

    Mark updateMark(Mark mark);

    void deleteMarkById(Long id);

}
