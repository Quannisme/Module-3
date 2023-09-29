package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.CustomerType;

import java.util.List;

public interface CustomerTypeServiceInter {
    CustomerType findId(int id);
    List<CustomerType>findAll();
}
