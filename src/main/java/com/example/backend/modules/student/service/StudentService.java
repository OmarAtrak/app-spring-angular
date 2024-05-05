package com.example.backend.modules.student.service;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    public Student getByCode(String code) {
        return this.studentRepository.findOneByCode(code);
    }

    public Student getById(Long id) {
        return this.studentRepository.findOneById(id);
    }

    public boolean deleteById(Long id) {
        this.studentRepository.deleteById(id);
        Student student = this.studentRepository.findOneById(id);
        return student == null;
    }

    public List<Student> getAllByProgramme(Long programmeId) {
        return this.studentRepository.findByProgramId(programmeId);
    }
}
