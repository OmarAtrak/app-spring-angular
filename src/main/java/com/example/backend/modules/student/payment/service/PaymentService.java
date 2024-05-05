package com.example.backend.modules.student.payment.service;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.payment.entity.Payment;
import com.example.backend.modules.student.payment.entity.PaymentStatus;
import com.example.backend.modules.student.payment.entity.PaymentType;
import com.example.backend.modules.student.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return this.paymentRepository.save(payment);
    }

    public List<Payment> getAll() {
        return this.paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return this.paymentRepository.findOneById(id);
    }

    public List<Payment> getAllByType(PaymentType type) {
        return this.paymentRepository.findByType(type);
    }

    public List<Payment> getAllByStatus(PaymentStatus status) {
        return this.paymentRepository.findByStatus(status);
    }

    public List<Payment> getByStudentId(Student student) {
        return this.paymentRepository.findByStudent(student);
    }

    public boolean deleteById(Long id) {
        this.paymentRepository.deleteById(id);
        Payment payment = this.paymentRepository.findOneById(id);
        return payment == null;
    }

}
