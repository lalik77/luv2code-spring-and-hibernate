package com.mami.luv2codes.hibernate.tutorial.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        String user = "springstudent"; // check 'localhost' if is changed by '%'
        String pass = "springstudent";


        try {

            System.out.println("Connecting  to db " + jdbcUrl );

            DataSource dataSource;
            Connection myConnection =
                    DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection success");

        }catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}