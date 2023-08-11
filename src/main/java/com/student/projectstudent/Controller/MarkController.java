package com.student.projectstudent.Controller;



import com.student.projectstudent.Entity.Mark;
import com.student.projectstudent.Entity.Student;
import com.student.projectstudent.Entity.Subject;
import com.student.projectstudent.Service.MarkService;
import com.student.projectstudent.Service.StudentService;
import com.student.projectstudent.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MarkController {
    @Autowired
    private MarkService markService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/marks")
    public String listStudents(Model model) {
        model.addAttribute("marks", markService.getAllMarks());
        return "mark";
    }
    @GetMapping("/marks/new")
    public String createMarkForm(Model model) {

        // create student object to hold student form data
        Mark mark=new Mark();
        System.out.println(mark.getMarkId());
        Student st=new Student();
        System.out.println(st.getId());
        Subject sb=new Subject();
        System.out.println(sb.getId());
        mark.setSubject(sb);
        mark.setStudent(st);

        model.addAttribute("mark", mark);
        return "create_mark";

    }
    @PostMapping("/marks")
    public String saveMark(@ModelAttribute("mark") Mark mark) {
       Long idsb=subjectService.findSubjectIdByName(mark.getSubject().getName());
       Long idst=studentService.findStudentIdByFullName(mark.getStudent().getFirstName(),mark.getStudent().getLastName());
       System.out.println(mark.getMarksObtained());
        System.out.println(idst);
        System.out.println(idsb);
        System.out.println(mark.getExamDate());


        markService.saveMark(idst,mark,idsb);
        return "redirect:/marks";
    }
    @GetMapping("/marks/edit/{id}")
    public String editMarkForm(@PathVariable Long id, Model model) {

        model.addAttribute("mark", markService.getMarkById(id));
        return "edit_student";
    }
    @GetMapping("/marks/{id}")
    public String deleteStudent(@PathVariable Long id) {
        markService.deleteMarkById(id);
        return "redirect:/marks";
    }
    @PostMapping("/marks/{id}")
    public String editStudent(@ModelAttribute("mark") Mark mark) {
        markService.saveMark(mark.getStudent().getId(),mark,mark.getSubject().getId());
        return "redirect:/marks";
    }
}
