package com.upc.edu.E03.repository;

import com.upc.edu.E03.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByNameCustomer(String nameCustomer);
    boolean existsByNameCustomerAndNumberAccount(String nameCustomer, String numberAccount);
}
