package com.example.backend.modules.student;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.repository.StudentRepository;
import io.swagger.v3.core.util.Json;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student/")
public class StudentResource {
    private StudentRepository studentRepository;

    @Autowired
    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("save")
    public Student save(@Valid @RequestBody Student student) {
        return this.studentRepository.save(student);
    }

    @GetMapping("index")
    public List<Student> index(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<Student> students = this.studentRepository.findByActiveTrue(pageable);

        return students;
    }

    @GetMapping("get/{id}")
    public Student get(@PathVariable("id") Long id) {
        return this.studentRepository.findOneById(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        Student student = this.studentRepository.findOneById(id);

        if(student != null) {
            student.setActive(false);
            Student deletedStudent = this.studentRepository.save(student);

            return !deletedStudent.isActive();
        }
        return false;
    }

    @GetMapping("prgrame/{programId}")
    public List<Student> studentOfPrograme(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @PathVariable("programId") Long programId
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<Student> students = this.studentRepository.findByProgramIdAndActiveTrue(programId, pageable);

        return students;
    }


}
