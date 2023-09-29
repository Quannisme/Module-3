package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.Employee;

import java.util.List;

public interface EmployeeRepoInter {
    void add(Employee employee);
    List<Employee> FindAll();
    void delete(String id);
    void update(Employee employee);
    Employee findById(String id);
    Employee findByName(String name);
    List<Employee>showBy(String  id, String name ,String idcard);
}
