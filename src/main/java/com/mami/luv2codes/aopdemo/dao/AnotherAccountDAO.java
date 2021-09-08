package com.mami.luv2codes.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AnotherAccountDAO {

    public void addAccount() {

        System.out.println("Doing work in :" + getClass() );
    }
}
