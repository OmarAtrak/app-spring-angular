package com.example.backend.modules.student.payment;

import com.example.backend.modules.student.entity.Student;
import com.example.backend.modules.student.payment.entity.Payment;
import com.example.backend.modules.student.payment.entity.PaymentStatus;
import com.example.backend.modules.student.payment.entity.PaymentType;
import com.example.backend.modules.student.payment.service.PaymentService;
import com.example.backend.modules.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment/")
public class PaymentResource {
    private final PaymentService paymentService;
    private final StudentService studentService;

    @Autowired
    public PaymentResource(PaymentService paymentService, StudentService studentService) {
        this.paymentService = paymentService;
        this.studentService = studentService;
    }

    @PostMapping("save")
    public Payment save(@RequestBody Payment payment) {
        return this.paymentService.save(payment);
    }

    @GetMapping("index")
    public List<Payment> index() {
        return this.paymentService.getAll();
    }

    @GetMapping("get/{id}")
    public Payment getById(@PathVariable("id") Long id) {
        return this.paymentService.getById(id);
    }

    @GetMapping("index/type/{type}")
    public List<Payment> getAllByType(@PathVariable("type") PaymentType type) {
        return this.paymentService.getAllByType(type);
    }

    @GetMapping("index/status/{status}")
    public List<Payment> getAllByStatus(@PathVariable("status") PaymentStatus status) {
        return this.paymentService.getAllByStatus(status);
    }

    @GetMapping("index/student/{student_id}")
    public List<Payment> getAllByStudent(@PathVariable("student_id") Long studentId) {
        Student student = this.studentService.getById(studentId);
        return this.paymentService.getByStudentId(student);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return this.paymentService.deleteById(id);
    }
}
