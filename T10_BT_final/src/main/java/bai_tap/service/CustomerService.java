package bai_tap.service;

import bai_tap.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private static List<Customer> CustomerList;
    static {
        CustomerList=new ArrayList<>();
        String ig="/image/Thong-tin-Anh-Phan.jpg";
        CustomerList.add(new Customer("Nguyen Van A","1/2/2003","Ha noi","/image/Thong-tin-Anh-Phan.jpg"));
        CustomerList.add(new Customer("Nguyen Van A","1/2/2003","Ha noi",ig));
        CustomerList.add(new Customer("Nguyen Van A","1/2/2003","Ha noi",ig));
        CustomerList.add(new Customer("Nguyen Van A","1/2/2003","Ha noi",ig));
    }
    public List<Customer>getList(){
        return new ArrayList<>(CustomerList);
    }
}
