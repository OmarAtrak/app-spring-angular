package com.example.backend.modules.student.repository;

import com.example.backend.modules.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findOneById(Long id);
    Student findOneByCode(String code);
    List<Student> findByProgramId(Long programId);
}
