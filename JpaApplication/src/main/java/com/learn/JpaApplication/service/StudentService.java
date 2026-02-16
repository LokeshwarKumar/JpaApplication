package com.learn.JpaApplication.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learn.JpaApplication.model.Student;
import com.learn.JpaApplication.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public Student saveStudent(Student student) {
        return repository.save(student);
    }
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);

        existing.setName(updatedStudent.getName());
        existing.setDepartment(updatedStudent.getDepartment());
        existing.setCity(updatedStudent.getCity());
        existing.setActive(updatedStudent.getActive());

        return repository.save(existing);
    }
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }
    public Page<Student> getStudentsWithPagination(Pageable pageable) {
        return repository.findAll(pageable);
    }
    public List<Student> getStudentsWithSorting(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
    public List<Student> getByDepartment(String dept) {
        return repository.findByDepartment(dept);
    }
    public List<Student> getByCity(String city) {
        return repository.findByCity(city);
    }
    public List<Student> getActiveStudents() {
        return repository.findActive();
    }
}