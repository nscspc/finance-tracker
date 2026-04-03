package com.example.finance.dto;

import com.example.finance.enums.RecordType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateRecordRequest {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0. Negative values are not allowed")
    private BigDecimal amount;

    private RecordType type;

    private String category;

    private LocalDate date;

    private String description;

}