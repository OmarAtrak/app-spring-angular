package com.example.backend.modules.student.payment.repository;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.payment.entity.Payment;
import com.example.backend.modules.student.payment.entity.PaymentStatus;
import com.example.backend.modules.student.payment.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findOneById(Long id);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
    List<Payment> findByStudent(Student student);
}
