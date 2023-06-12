package com.upc.edu.E03.service.impl;

import com.upc.edu.E03.model.Account;
import com.upc.edu.E03.service.AccountService;
import com.upc.edu.E03.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public Account createAccount(Account account){return accountRepository.save(account);}
}
