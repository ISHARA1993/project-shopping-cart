package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Account;
import com.crickburgerweb.shoppingcart.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository theAccountRepository) {
        accountRepository = theAccountRepository;
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findByUsername(String username) {
        Optional<Account> result = accountRepository.findById(username);
        if (!result.isPresent()) {
            System.out.println("no product");
            return null;
        }
        return result.get();

    }

    @Override
    public void save(Account theAccount) {
        accountRepository.save(theAccount);
    }

    //new method check
    @Override
    public void deleteByUsername(String theUsername) {
        accountRepository.deleteById(theUsername);
    }
}
