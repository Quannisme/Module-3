package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.Employee;
import com.example.casestudy.code.reponsitory.impl.EmployeeReponImple;
import com.example.casestudy.code.reponsitory.inter.EmployeeRepoInter;
import com.example.casestudy.code.service.inter.EmployeeServiceInter;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeServiceInter {
    EmployeeRepoInter employeeRepo =new EmployeeReponImple();

    @Override
    public void add(Employee employee) {
        employeeRepo.add(employee);
    }

    @Override
    public List<Employee> FindAll() {
        return employeeRepo.FindAll();
    }

    @Override
    public void delete(String id) {
        employeeRepo.delete(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepo.update(employee);
    }

    @Override
    public Employee findById(String id) {
        return employeeRepo.findById(id);
    }


    @Override
    public Employee findByName(String name) {
        return employeeRepo.findByName(name);
    }

    @Override
    public List<Employee> showBy(String id, String name, String idcard) {
        return employeeRepo.showBy(id,name,idcard);
    }
}
