package com.example.backend.modules.student;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentResource {
    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("save")
    public Student save(@Valid @RequestBody Student student) {
        return this.studentService.save(student);
    }

    @GetMapping("index")
    public List<Student> index() {
        return this.studentService.getAll();
    }

    @GetMapping("get/{code}")
    public Student get(@PathVariable("code") String code) {
        return this.studentService.getByCode(code);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return this.studentService.deleteById(id);
    }

    @GetMapping("index/programme/{programmeId}")
    public List<Student> studentsByProgramme(@PathVariable("programmeId") Long programmeId) {
        return this.studentService.getAllByProgramme(programmeId);
    }
}
