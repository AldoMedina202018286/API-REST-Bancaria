package com.upc.edu.E03.controller;


import com.upc.edu.E03.exception.ValidationException;
import com.upc.edu.E03.model.Account;
import com.upc.edu.E03.repository.AccountRepository;
import com.upc.edu.E03.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank/v1")

public class AccountController {

    @Autowired
    private AccountService accountService;

    private final AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //EndPoint: http://localhost:8080/api/bank/v1/accounts
    //Method: GET
    @Transactional(readOnly = true)
    @RequestMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<List<Account>>(accountRepository.findAll(), HttpStatus.OK);
    }

    //EndPoint: http://localhost:8080/api/bank/v1/accounts/filterByNameCustoemr
    //Method: GET
    @Transactional(readOnly = true)
    @RequestMapping("/accounts/filterByNameCustomer")
    public ResponseEntity<List<Account>> getAccountsBynameCustomer(@RequestParam("nameCustomer") String nameCustomer){
        return new ResponseEntity<List<Account>>(accountRepository.findByNameCustomer(nameCustomer), HttpStatus.OK);

    }

    //EndPoint: http://localhost:8080/api/bank/v1/accounts/
    //Method: POST
    @Transactional
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){

        existByNumberAccountAndNameCustomer(account);
        validateAccount(account);
        return new ResponseEntity<>(accountRepository.save(account), HttpStatus.CREATED);

    }




    public void validateAccount(Account account) {
        if (account.getNameCustomer() == null || account.getNameCustomer().trim().isEmpty())
            throw new ValidationException("El nombre del cliente es obligatorio");


        if (account.getNameCustomer().length() > 30)
            throw new ValidationException("El nombre del cliente no debe exceder los 30 caracteres");


        if (account.getNumberAccount() == null || account.getNumberAccount().trim().isEmpty())
            throw new ValidationException("El número de cuenta es obligatorio");


        if (account.getNumberAccount().length() > 13){
            throw new ValidationException("El número de cuenta debe tener una longitud de 13 caracteres");
        }

    }

    private void existByNumberAccountAndNameCustomer(Account account) {
        if (accountRepository.existsByNameCustomerAndNumberAccount(account.getNumberAccount(), account.getNameCustomer())) {
            throw new ValidationException("No se puede registrar la cuenta porque ya existe una con esos datos");
        }
    }

}
