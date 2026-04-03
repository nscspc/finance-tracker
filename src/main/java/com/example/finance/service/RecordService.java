package com.example.finance.service;

import com.example.finance.dto.CreateRecordRequest;
import com.example.finance.entity.FinancialRecord;
import com.example.finance.enums.RecordType;
import com.example.finance.mapper.FinancialRecordMapper;
import com.example.finance.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository recordRepository;

    public FinancialRecord createRecord(CreateRecordRequest request) {

        FinancialRecord record = FinancialRecordMapper.toEntity(request);

        return recordRepository.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    public FinancialRecord updateRecord(Long id, CreateRecordRequest request) {

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(request.getAmount());
        record.setCategory(request.getCategory());
        record.setType(request.getType());

        return recordRepository.save(record);
    }

    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    public List<FinancialRecord> filterRecords(String category, RecordType type) {

        if(category != null) {
            return recordRepository.findByCategory(category);
        }

        if(type != null) {
            return recordRepository.findByType(type);
        }

        return recordRepository.findAll();
    }

}