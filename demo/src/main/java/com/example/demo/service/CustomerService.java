package com.example.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.QCustomer;
// import com.example.demo.repository.CustomerRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.SQLQueryFactory;

@Service
public class CustomerService {
    //@Autowired
    @PersistenceContext
    EntityManager entityManager;

    // @Autowired
    // private CustomerRepository customerRepository;

    public void example2() {
        // customerRepository.save(new Customer("Jack", "Bauer"));
        // customerRepository.save(new Customer("Chloe", "O'Brian"));
        // customerRepository.save(new Customer("Kim", "Bauer"));
        // customerRepository.save(new Customer("David", "Palmer"));
        // customerRepository.save(new Customer("Michelle", "Dessler"));

        var customer = QCustomer.customer;

        var queryFactory = new JPAQueryFactory(entityManager);
        var sqlQueryFactory = new SQLQueryFactory(entityManager);
        
        // QueryDSLのJPAQueryFactoryは主にデータベースからデータを
        // 取得するためのクエリを構築するために使用されますが、
        // 挿入や更新はJPAの機能を利用して行うことが推奨されます。


        {
            // var query = queryFactory
            //     .insert(customer)
            //     .set(customer.firstName, "Jack")
            //     .set(customer.lastName, "Bauer")
            //     ;

            var query = queryFactory
                .insert(customer)
                .columns(customer.firstName, customer.lastName)
                .values("Jack", "Bauer")
                ;

            System.out.println(query);

            var insertCount = query.execute();
            System.out.println("insertCount = " + insertCount);
        }
        

        {
            var query = queryFactory
                .select(customer)
                .from(customer)
                .orderBy(customer.firstName.asc(),customer.lastName.asc())
                ;

            System.out.println(query);

            var list = query.fetch();



            // var result = query
            //     .from(customer)
            //     //.where(qCustomer.firstName.startsWith("J"))
            //     .orderBy(customer.firstName.asc(),customer.lastName.asc())
            //     .fetch();
    
            
            list.forEach(c -> {
                System.out.println(c.toString());
            });
        }
        




    }

    public void example1() {
        // JPQLQueryFactory query = new JPAQueryFactory(em);

        // customerRepository.save(new Customer("Jack", "Bauer"));
        // customerRepository.save(new Customer("Chloe", "O'Brian"));
        // customerRepository.save(new Customer("Kim", "Bauer"));
        // customerRepository.save(new Customer("David", "Palmer"));
        // customerRepository.save(new Customer("Michelle", "Dessler"));

        // var qCustomer = QCustomer.customer;
        // var query = new JPAQuery<Customer>(entityManager);

    

        // var c1 = query.from(qCustomer).fetch();

        // c1.forEach(c -> {
        //     System.out.println(c.toString());
        // });

    }


}
