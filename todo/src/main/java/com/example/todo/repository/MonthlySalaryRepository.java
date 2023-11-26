package com.example.todo.repository;

import com.example.todo.dto.SalaryDto;
import com.example.todo.model.MonthlySalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MonthlySalaryRepository extends JpaRepository<MonthlySalary, Long> {

    @Query(value = """
            SELECT ms.id AS id, m1.name AS accountantName, MONTH(ms.time) AS month, CAST(m2.salary AS decimal(18,2)) AS fixedSalary,
            ms.insurance_fee AS insuranceFee, ms.tax_fee AS taxFee, ms.bonus AS bonus, ms.penalty AS penalty,
            (m2.salary + ms.bonus - ms.insurance_fee - ms.tax_fee - ms.penalty) AS total
            FROM monthly_salary ms JOIN member m1 on m1.id = ms.accountant_id JOIN member m2 ON ms.owner_id = m2.id
            WHERE ms.owner_id = :userId
            AND :startMonth <= MONTH(ms.time) AND MONTH(ms.time) <= :endMonth
            AND YEAR(ms.time) = :year
            """
            , nativeQuery = true)
    List<SalaryDto> getSalaryUser(Long userId,
                                  Integer startMonth,
                                  Integer endMonth,
                                  Integer year);
}
