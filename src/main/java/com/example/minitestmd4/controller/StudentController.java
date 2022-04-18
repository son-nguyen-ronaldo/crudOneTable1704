package com.example.minitestmd4.controller;

import com.example.minitestmd4.model.Student;
import com.example.minitestmd4.repository.StudentRepo;
import com.example.minitestmd4.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/student")
    public ModelAndView show(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listStudent", studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("addStudent", new Student());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView add(@Validated @ModelAttribute(value = "addStudent") Student student, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView =new ModelAndView("/create");
            modelAndView.addObject("addStudent",student);
            return modelAndView;
        }
        studentService.save(student);
        return new ModelAndView("redirect:/student");
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int index) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("editStudent", studentService.findAll().get(index));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute Student student) {
        studentService.save(student);
        return new ModelAndView("redirect:/student");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        studentService.delete(id);
        return new ModelAndView("redirect:/student");
    }

    @PostMapping("/seach")
    public ModelAndView seach(@RequestParam String findname) {
        ModelAndView modelAndView = new ModelAndView("seach");
        modelAndView.addObject("listStudent", studentService.findByName(findname));
        return modelAndView;
    }
}
