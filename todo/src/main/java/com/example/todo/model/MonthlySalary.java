package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "monthly_salary")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlySalary implements Serializable {

    private static final long serialVersionUID = -197553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "accountant_id")
    private Long accountantId;

    @Column(name = "time")
    private LocalDate time;

    @Column(name = "insurance_fee")
    private Float insuranceFee;

    @Column(name = "tax_fee")
    private Float taxFee;

    @Column(name = "bonus")
    private Float bonus;

    @Column(name = "penalty")
    private Float penalty;

    @Column(name = "is_final")
    private Boolean isFinal;
}
