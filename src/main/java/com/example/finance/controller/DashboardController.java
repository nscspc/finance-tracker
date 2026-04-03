package com.example.finance.controller;

import com.example.finance.dto.CategorySummaryDTO;
import com.example.finance.dto.MonthlyTrendDTO;
import com.example.finance.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummary() {
        return ResponseEntity.ok(dashboardService.getSummary());
    }

    @GetMapping("/category-summary")
    public ResponseEntity<List<CategorySummaryDTO>> categorySummary() {
        return ResponseEntity.ok(dashboardService.getCategorySummary());
    }

    @GetMapping("/monthly-trends")
    public ResponseEntity<List<MonthlyTrendDTO>> monthlyTrends() {
        return ResponseEntity.ok(dashboardService.getMonthlyTrends());
    }
}