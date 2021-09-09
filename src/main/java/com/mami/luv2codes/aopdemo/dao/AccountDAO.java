package com.mami.luv2codes.aopdemo.dao;

import com.mami.luv2codes.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount (Account theAccount) {

        System.out.println(getClass() + ": DOING MY DB WORK : ADDING ACCOUNT");
    }
}
