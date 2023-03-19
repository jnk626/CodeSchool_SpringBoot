package org.generation.italy.legion.controllers;

import org.generation.italy.legion.model.entities.Level;
import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;
import org.generation.italy.legion.model.services.abstractions.AbstractTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherController {
    private AbstractTeacherService service;

    @Autowired
    public TeacherController(AbstractTeacherService service) {
        this.service = service;
    }

    @GetMapping("/find-teacher")
    public String showFind() {
        return "find-teacher";
    }

    @GetMapping("/findTeacherBySkillLevel")
    public String findBySkillLevel(Model model, long idSkill, Level level) {
        List<Teacher> teachers = service.findWithSkillAndLevel(idSkill, level);
        model.addAttribute("teachers", teachers);
        return "teachers";
    }
}
