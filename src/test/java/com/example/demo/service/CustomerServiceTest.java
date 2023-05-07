package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Customer;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    @DisplayName("手動実行")
    @Tag("manual")
    public void example1() throws Exception {
        customerService.example1();
    }

    @Test
    @DisplayName("手動実行")
    @Tag("manual")
    public void example2() throws Exception {
        customerService.example2();
    }

    @Test
    @DisplayName("手動実行")
    @Tag("manual")
    public void example3() throws Exception {
        customerService.example3();
    }
}
