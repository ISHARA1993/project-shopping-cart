package com.crickburgerweb.shoppingcart.service;

import com.crickburgerweb.shoppingcart.Entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findByUsername(String username);

    public void save(Account theAccount);

    public void deleteByUsername(String username);

}
