package com.example.finance.repository;

import com.example.finance.dto.CategorySummaryDTO;
import com.example.finance.dto.MonthlyTrendDTO;
import com.example.finance.entity.FinancialRecord;
import com.example.finance.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);

    @Query("SELECT new com.example.finance.dto.CategorySummaryDTO(r.category, SUM(r.amount)) " +
            "FROM FinancialRecord r GROUP BY r.category")
    List<CategorySummaryDTO> getCategorySummary();

    @Query("SELECT new com.example.finance.dto.MonthlyTrendDTO(" +
            "CONCAT(YEAR(r.date), '-', MONTH(r.date)), SUM(r.amount)) " +
            "FROM FinancialRecord r GROUP BY YEAR(r.date), MONTH(r.date)")
    List<MonthlyTrendDTO> getMonthlyTrends();

}