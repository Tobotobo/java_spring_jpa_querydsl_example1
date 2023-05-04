package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.QCustomer;
import com.example.demo.repository.CustomerRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Service
public class CustomerService {
    //@Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    public void example1() {
        // JPQLQueryFactory query = new JPAQueryFactory(em);

        customerRepository.save(new Customer("Jack", "Bauer"));
        customerRepository.save(new Customer("Chloe", "O'Brian"));
        customerRepository.save(new Customer("Kim", "Bauer"));
        customerRepository.save(new Customer("David", "Palmer"));
        customerRepository.save(new Customer("Michelle", "Dessler"));

        var qCustomer = QCustomer.customer;
        var query = new JPAQuery<Customer>(entityManager);

    

        var c1 = query.from(qCustomer).fetch();

        c1.forEach(c -> {
            System.out.println(c.toString());
        });

    }


}
