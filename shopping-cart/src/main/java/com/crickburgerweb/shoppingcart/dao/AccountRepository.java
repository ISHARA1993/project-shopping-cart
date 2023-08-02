package com.crickburgerweb.shoppingcart.dao;


import com.crickburgerweb.shoppingcart.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByUserName(String userName);
}
