package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.Customer;

import java.util.List;

public interface CustomerInter {
    List<Customer>findAll();
    Customer findById(String id);
    void deleteById(String id);
    void edit(Customer customer);
    void add(Customer customer);
}
