package com.example.sprinng__crud.controller;

import java.util.List;
import java.util.Locale;


import com.example.sprinng__crud.model.Student;
import com.example.sprinng__crud.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    StudentService service;

    @Autowired
    MessageSource messageSource;

    /*
     * List all existing Students.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listStudents(ModelMap model) {
        List<Student> students = service.findAllStudents();
        model.addAttribute("students", students);
        return "allstudents";
    }
    @RequestMapping(value = { "/search" }, method = RequestMethod.GET)
    public String searchStudentsByName(@RequestParam("name") String name, ModelMap model) {
        List<Student> students = service.findStudentsByName(name);
        model.addAttribute("students", students);
        return "allstudents";
    }

    /*
     * Add a new Student.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newStudent(ModelMap model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("edit", false);
        return "registration";
    }

    /*
     * Handling POST request for validating the user input and saving Student in database.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result,
                              ModelMap model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "registration";
        }

        if (!service.isStudentCodeUnique(student.getId(), student.getCode())) {
            FieldError codeError = new FieldError("Student", "code", messageSource.getMessage("non.unique.code", new String[]{student.getCode()}, Locale.getDefault()));
            result.addError(codeError);
            return "registration";
        }

        service.saveStudent(student);

        redirectAttributes.addFlashAttribute("successMessage", "Student " + student.getName() + " registered successfully");

        return "redirect:/list";
    }
///////////////////////
    /*
     * Provide the existing Student for updating.
     */
    @RequestMapping(value = { "/edit" }, method = RequestMethod.GET)
    public String editStudent(@RequestParam("studentId") int studentId, ModelMap model) {
        // Récupérer les détails de l'étudiant à éditer en fonction de son identifiant
        Student student = service.findById(studentId);
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "editstudent";
    }

    /*
     * Handling POST request for validating the user input and updating Student in database.
     */
    @RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, BindingResult result,
                                ModelMap model, @RequestParam("studentId") int studentId,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "editstudent";
        }

        Student existingStudent = service.findById(studentId);
        if (existingStudent == null) {
            model.addAttribute("error", "Student not found");
            return "error";
        }

        existingStudent.setName(student.getName());
        existingStudent.setBirthDate(student.getBirthDate());
        existingStudent.setNationality(student.getNationality());
        existingStudent.setCode(student.getCode());

        service.saveOrUpdate(existingStudent);

        redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully");

        return "redirect:/list";
    }

    /*
     * Delete an Student by it's CODE value.
     */
    @RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("studentId") int studentId, RedirectAttributes redirectAttributes) {
        // Supprimer l'étudiant
        service.deleteStudentById(studentId);

        // Ajouter le message de succès de suppression à la redirection
        redirectAttributes.addFlashAttribute("deleteMessage", "Student deleted successfully");

        // Rediriger vers la page list des étudiants
        return "redirect:/list";
    }



}
