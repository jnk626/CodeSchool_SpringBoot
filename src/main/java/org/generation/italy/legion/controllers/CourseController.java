package org.generation.italy.legion.controllers;

import jakarta.validation.Valid;
import org.generation.italy.legion.model.data.exceptions.DataException;
import org.generation.italy.legion.model.entities.Course;
import org.generation.italy.legion.model.services.abstractions.AbstractDidacticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {
    private AbstractDidacticService service;

    @Autowired
    public CourseController(AbstractDidacticService service) {
        this.service = service;
    }
    @GetMapping("/home")
    public String showMenu() {
        return "home";
    }

    @GetMapping("/add-new-course")
    public String showForm(Course course){
        return "add-new-course";
    }

    @PostMapping("/addNewCourse") //questo usa il method POST
    public String addNewCourse(Model m, @Valid Course c, BindingResult result) { // Valid attiva la validazione, BindingResult si tiene in pancia i valori del form e li verifica
        if (result.hasErrors()) {
            return "add-new-course"; //vanno aggiunte sull'html i vari span con i th:errors
        }
        try {
            Course newCourse = service.saveCourse(c);
            m.addAttribute("newCourse", newCourse);
            return "redirect:/showCourses";
        } catch (DataException e) {
            e.printStackTrace();
            m.addAttribute("error", e.getCause().getMessage());
            return "error";
        }
    }

    @GetMapping("/showCourses")
    public String showCourses(Model m){  // Model è un oggetto che trasferisce dati tra il Controller e la View
        try {
            List<Course> courseList = service.findAllCourses();
            m.addAttribute("courses", courseList);
            return "courses";
        } catch (DataException e) {
            e.printStackTrace();
            m.addAttribute("error", e.getCause().getMessage());
            return "error";
        }
    }

    @GetMapping("/find-course")
    public String showFind(){
        return "find-course";
    }

    @GetMapping("/findCourseById")
    public String findById(Model m, long courseId){
        try {
            Optional<Course> c = service.findCourseById(courseId);
            Course found = c.orElse(new Course());
            m.addAttribute("course", found);
            return "course_detail";
        } catch (DataException e) {
            e.printStackTrace();
            m.addAttribute("error", e.getCause().getMessage());
            return "error";
        }
    }

    @GetMapping("/findCourseByTitle")
    public String findByTitle(Model m, String title) {
        try {
            List<Course> courseList = service.findCoursesByTitleContains(title);
            m.addAttribute("courses", courseList);
            return "courses";
        } catch (DataException e) {
            e.printStackTrace();
            m.addAttribute("error", e.getCause().getMessage());
            return "error";
        }
    }
}
