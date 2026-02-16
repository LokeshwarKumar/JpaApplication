package com.learn.JpaApplication.controller;
import java.util.*;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.JpaApplication.model.Student;
import com.learn.JpaApplication.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student deleted successfully";
    }
    @GetMapping("/page")
    public Page<Student> getStudentsWithPagination(Pageable pageable) {
        return service.getStudentsWithPagination(pageable);
    }
    @GetMapping("/sort")
    public List<Student> getStudentsWithSorting(@RequestParam String field) {
        return service.getStudentsWithSorting(field);
    }
    @GetMapping("/department/{dept}")
    public List<Student> getByDepartment(@PathVariable String dept) {
        return service.getByDepartment(dept);
    }
    @GetMapping("/city/{city}")
    public List<Student> getByCity(@PathVariable String city) {
        return service.getByCity(city);
    }
    @GetMapping("/active")
    public List<Student> getActiveStudents() {
        return service.getActiveStudents();
    }
}
