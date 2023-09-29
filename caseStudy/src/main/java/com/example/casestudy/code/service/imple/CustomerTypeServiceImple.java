package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.CustomerType;
import com.example.casestudy.code.reponsitory.impl.CustomerTypeImpl;
import com.example.casestudy.code.reponsitory.inter.CustomerTypeInter;
import com.example.casestudy.code.service.inter.CustomerTypeServiceInter;

import java.util.List;

public class CustomerTypeServiceImple implements CustomerTypeServiceInter {
    CustomerTypeInter customerTypeInter=new CustomerTypeImpl();
    @Override
    public CustomerType findId(int id) {
        return customerTypeInter.findCustomerTypeById(id);
    }

    @Override
    public List<CustomerType> findAll() {
        return customerTypeInter.findAll();
    }
}
