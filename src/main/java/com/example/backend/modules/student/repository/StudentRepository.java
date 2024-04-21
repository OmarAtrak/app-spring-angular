package com.example.backend.modules.student.repository;

import com.example.backend.modules.student.entity.Student;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findOneById(Long id);
    List<Student> findByProgramIdAndActiveTrue(Long programId, Pageable pageable);
    List<Student> findByActiveTrue(Pageable pageable);
}
