package com.upc.edu.E03.repository;

import com.upc.edu.E03.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByCreateDateBetween(LocalDate startDate,LocalDate endDate);
    List<Transaction> findByAccountId(Long id);






}
