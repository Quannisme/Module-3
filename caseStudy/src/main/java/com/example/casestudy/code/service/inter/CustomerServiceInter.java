package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.Customer;

import java.util.List;

public interface CustomerServiceInter {
    List<Customer> findAll();
    Customer findId(String id);
    void delete(String id);
    void update(Customer customer);
    void add(Customer customer);
}
