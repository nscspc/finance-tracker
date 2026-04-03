package com.example.finance.service;

import com.example.finance.dto.CategorySummaryDTO;
import com.example.finance.dto.MonthlyTrendDTO;
import com.example.finance.entity.FinancialRecord;
import com.example.finance.enums.RecordType;
import com.example.finance.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repository;

    public Map<String, Object> getSummary() {

        List<FinancialRecord> records = repository.findAll();

        BigDecimal income = records.stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .map(FinancialRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expense = records.stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .map(FinancialRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Map<String, Object> result = new HashMap<>();

        result.put("totalIncome", income);
        result.put("totalExpense", expense);
        result.put("netBalance", income.subtract(expense));

        return result;
    }

    public List<CategorySummaryDTO> getCategorySummary() {
        return repository.getCategorySummary();
    }

    public List<MonthlyTrendDTO> getMonthlyTrends() {
        return repository.getMonthlyTrends();
    }

}