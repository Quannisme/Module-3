package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.CustomerType;

import java.util.List;

public interface CustomerTypeInter {
    List<CustomerType> findAll();
    CustomerType findCustomerTypeById(int id);
}
