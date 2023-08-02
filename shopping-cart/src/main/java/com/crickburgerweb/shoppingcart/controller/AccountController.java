package com.crickburgerweb.shoppingcart.controller;


import com.crickburgerweb.shoppingcart.Entity.Account;
import com.crickburgerweb.shoppingcart.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class AccountController {

    private AccountService accountService;


    @Autowired
    public AccountController(AccountService theAccountService) {
        accountService = theAccountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/accounts/{username}")
    public Account findByUsername(@PathVariable String username) {
        Account theAccount = accountService.findByUsername(username);
        if (theAccount == null) {
            return null;
        }
        return theAccount;
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account account) {
        accountService.save(account);
        return account;
    }

    @PutMapping("/accounts")
    public void updateAccount(@RequestBody Account account) {
        accountService.save(account);
        System.out.println("Update success");
    }

    @DeleteMapping("/accounts/{username}")
    public void deleteProduct(@PathVariable String username) {
        if (accountService.findByUsername(username) != null) {
            accountService.deleteByUsername(username);
            System.out.println("delete success");
        }
        System.out.println("no username");
    }

}
