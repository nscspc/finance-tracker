package com.example.finance.mapper;

import com.example.finance.dto.CreateRecordRequest;
import com.example.finance.entity.FinancialRecord;

public class FinancialRecordMapper {

    private FinancialRecordMapper() {}

    public static FinancialRecord toEntity(CreateRecordRequest request) {

        return FinancialRecord.builder()
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .date(request.getDate())
                .description(request.getDescription())
                .build();
    }
}