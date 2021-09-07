package com.mami.luv2codes.springdemo.dao;

import com.mami.luv2codes.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {


        // get the current hibernate session

        Session currentSession = sessionFactory.getCurrentSession();

        // create query

        Query<Customer> thQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);


        //execute query

        List<Customer> customers = thQuery.getResultList();

        //return the results

        return customers;

    }


    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int theId) {


        //get the current hibernate session

        Session currentSession = sessionFactory.getCurrentSession();

        // now retrieve /read from database using the primary key

        Customer theCustomer = currentSession.get(Customer.class,theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {



        //get the current hibernate session

        Session currentSession = sessionFactory.getCurrentSession();

        // delete from database customer with id= theId

        Customer theCustomer = currentSession.get(Customer.class,theId);
        currentSession.delete(theCustomer);


    }
}
