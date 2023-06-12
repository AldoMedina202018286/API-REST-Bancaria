package com.upc.edu.E03.repository;

import com.upc.edu.E03.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByNameCustomer(String nameCustomer);



    boolean existsByNameCustomerAndNumberAccount(String nameCustomer, String numberAccount);
}
