package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.Customer;
import com.example.casestudy.code.reponsitory.impl.CustomerImple;
import com.example.casestudy.code.reponsitory.inter.CustomerInter;
import com.example.casestudy.code.service.inter.CustomerServiceInter;

import java.util.List;

public class CustomerServiceImpl implements CustomerServiceInter {
    CustomerInter customerInter=new CustomerImple();
    @Override
    public List<Customer> findAll() {
        return customerInter.findAll();
    }

    @Override
    public Customer findId(String id) {
        return customerInter.findById(id);
    }

    @Override
    public void delete(String id) {
        customerInter.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        customerInter.edit(customer);
    }

    @Override
    public void add(Customer customer) {
        customerInter.add(customer);
    }
}
