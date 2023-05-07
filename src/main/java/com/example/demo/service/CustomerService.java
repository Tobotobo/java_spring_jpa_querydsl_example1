package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.QCustomer;
import com.example.demo.repository.CustomerRepository;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.dml.SQLInsertClause;

@Service
public class CustomerService {
    //@Autowired
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CustomerRepository customerRepository;

    public void example1() {
        // customerRepository.save(new Customer("Jack", "Bauer"));
        // customerRepository.save(new Customer("Chloe", "O'Brian"));
        // customerRepository.save(new Customer("Kim", "Bauer"));
        // customerRepository.save(new Customer("David", "Palmer"));
        // customerRepository.save(new Customer("Michelle", "Dessler"));

        // var customers = new Customer[] {
        //     new Customer("Jack", "Bauer")
        // };

        customerRepository.saveAll(Arrays.asList(
            new Customer("Jack", "Bauer"),
            new Customer("Chloe", "O'Brian"),
            new Customer("Kim", "Bauer"),
            new Customer("David", "Palmer"),
            new Customer("Michelle", "Dessler")
        ));

        var qCustomer = QCustomer.customer;
        var query = new JPAQuery<Customer>(entityManager);

        var c1 = query.from(qCustomer).fetch();

        c1.forEach(c -> {
            System.out.println(c.toString());
        });
    }

    public void example2() throws Exception {
        // 色々やってみた結論
        // 更新はおとなしくRepository.save() or saveAll()を使いましょう

        // var jpaQueryFactory = new JPAQueryFactory(entityManager);
        
        // var customer = QCustomer.customer;

        // customerRepository.

        // var query = jpaQueryFactory.insert(customer)
        //     .set(customer.firstName, "Jack")
        //     .set(customer.lastName, "Bauer");
        // 上記を実行すると生成されるSQL
        // insert into Customer (firstName, lastName)
        // customer.firstName = ?1, customer.lastName = ?2
        // 発生するエラー
        // antlr.NoViableAltException: unexpected token: customer

        // var query = jpaQueryFactory.insert(customer)
        //     .columns(customer.firstName, customer.lastName)
        //     .values("Jack", "Bauer");
        // 上記を実行すると生成されるSQL
        // insert into Customer (firstName, lastName)
        //
        // values  (?1, ?2)
        // 発生するエラー
        // antlr.NoViableAltException: unexpected token: values

        // System.out.println(query.toString());
        // query.execute();
            // .set(customer.firstName, "Jack")
            // .set(customer.lastName, "Bauer")
            // ;
        
        // customerRepository.save(new Customer("Jack", "Bauer"));
        // customerRepository.save(new Customer("Chloe", "O'Brian"));
        // customerRepository.save(new Customer("Kim", "Bauer"));
        // customerRepository.save(new Customer("David", "Palmer"));
        // customerRepository.save(new Customer("Michelle", "Dessler"));

        // var customer = QCustomer.customer;
        
        // //var queryFactory = new JPAQueryFactory(entityManager);
        

        // //com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);
        // SQLQueryFactory sqlQueryFactory = null;
        // {
        //     // Create an in-memory H2 database
        //     String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS test\\;SET SCHEMA test;";
        //     Connection connection = DriverManager.getConnection(url);
        //     // var sqlTemplates = H2Templates.builder().build();
        //     // com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(sqlTemplates);
        //     SQLTemplates templates = new H2Templates();
        //     Configuration configuration = new Configuration(templates);
        //     sqlQueryFactory = new SQLQueryFactory(configuration, () -> connection);
        //     // sqlQueryFactory = new SQLQueryFactory(configuration, dataSource);
        // }
        
        // QueryDSLのJPAQueryFactoryは主にデータベースからデータを
        // 取得するためのクエリを構築するために使用されますが、
        // 挿入や更新はJPAの機能を利用して行うことが推奨されます。


        // {
        //     // var query = queryFactory
        //     //     .insert(customer)
        //     //     .set(customer.firstName, "Jack")
        //     //     .set(customer.lastName, "Bauer")
        //     //     ;

        //     // SQLInsertClause query = sqlQueryFactory
        //     //     .insert(customer);

        //         // .columns(customer.firstName, customer.lastName)
        //         // .values("Jack", "Bauer")
        //         // ;

        //     // System.out.println(query);

        //     // var insertCount = query.execute();
        //     // System.out.println("insertCount = " + insertCount);
        // }
        

        // {
        //     var query = queryFactory
        //         .select(customer)
        //         .from(customer)
        //         .orderBy(customer.firstName.asc(),customer.lastName.asc())
        //         ;

        //     System.out.println(query);

        //     var list = query.fetch();



        //     // var result = query
        //     //     .from(customer)
        //     //     //.where(qCustomer.firstName.startsWith("J"))
        //     //     .orderBy(customer.firstName.asc(),customer.lastName.asc())
        //     //     .fetch();
    
            
        //     list.forEach(c -> {
        //         System.out.println(c.toString());
        //     });
        // }
        




    }




}
