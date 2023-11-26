package com.example.todo.dto;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public interface SalaryDto {
    Long getId();
    String getAccountantName();
    Integer getMonth();
    Float getFixedSalary();
    Float getInsuranceFee();
    Float getTaxFee();
    Float getBonus();
    Float getPenalty();
    Float getTotal();

    default String getTotalStr() {
        return NumberFormat.getNumberInstance(Locale.US).format(Float.parseFloat((BigDecimal.valueOf(getTotal())).toPlainString()));
    }

    default String getFixedSalaryStr() {
        return NumberFormat.getNumberInstance(Locale.US).format(Float.parseFloat((BigDecimal.valueOf(getFixedSalary())).toPlainString()));
    }
}
