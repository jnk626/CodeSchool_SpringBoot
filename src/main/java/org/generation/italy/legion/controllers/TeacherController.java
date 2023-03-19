package org.generation.italy.legion.controllers;

import org.generation.italy.legion.model.entities.Teacher;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeacherController {
    private AbstractDidacticService service;

    @Autowired
    public TeacherController(AbstractDidacticService service) {
        this.service = service;
    }

    @GetMapping("/find-teacher")
    public String showFind() {
        return "find-teacher";
    }

    @GetMapping("/findTeacherBySkillLevel")
    public String findBySkillLevel(Model model) {
        List<Teacher> teachers = null; // creare lo StandardTeacherService a partire dalla HibernateTeacherRepository prima di poter chiamare i metodi
        return "teachers";
    }
}
