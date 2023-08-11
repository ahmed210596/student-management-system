package com.student.projectstudent.Controller;

import com.student.projectstudent.Entity.Student;
import com.student.projectstudent.Entity.Subject;
import com.student.projectstudent.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @GetMapping("/subjects")
    public String listSubjects(Model model) {
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subject";
    }
    @GetMapping("/subjects/new")
    public String createSubjectForm(Model model) {

        // create student object to hold student form data
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create_subject";

    }
    @PostMapping("/subjects")
    public String saveSub(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }
    @PostMapping("/subjects/{id}")
    public String editSubject(@ModelAttribute("subject") Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }
    @GetMapping("/subjects/edit/{id}")
    public String editSubjectForm(@PathVariable Long id, Model model) {
        model.addAttribute("subject", subjectService.getSubjectById(id));
        return "edit_subject";
    }
    @GetMapping("/subjects/{id}")
    public String deleteStudent(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
}
