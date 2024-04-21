package com.example.backend.modules.student.repository;

import com.example.backend.modules.student.entity.Payement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement, Long> {
    Payement findOneById(Long id);
    List<Payement> findByActiveTrue(Pageable pageable);
}
