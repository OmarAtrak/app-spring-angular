package com.example.backend.modules.student.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private double amount;
    private Date date;
    private PayementType type;
    private PayementStatus status;
    private boolean active;
    private String file;
    @ManyToOne
    private Student student;
}
