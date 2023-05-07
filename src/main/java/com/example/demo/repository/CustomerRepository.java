package com.example.demo.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>, QuerydslPredicateExecutor<Customer> {

  // List<Customer> findByLastName(String lastName);

  // Customer findById(long id);
}