package com.example.casestudy.code.utill;

public class Constraints {
    //Division
    public static final String FIND_DIVISION_BYID="select * from division where division_id=?";
    public static final String FIND_ALL_DIVISION="select * from division";
    //Education Degree
    public static final String FIND_ALL_EDUCATION_DEGREE="select * from education_degree";
    public static final String FIND_ALL_EDUCATION_DEGREE_BY_ID="select * from education_degree where education_degree_id=?";
    //Position
    public static final String FIND_ALL_POSITION="select * from position";
    public static final String FIND_POSITION_BY_ID="select * from position where position_id=?";
    //User
    public static final String FIND_ALL_USER="select * from user";
    public static final String FIND_USER_BY_NAME="select * from user where username=? ";
    public static final String CREATE_USER="insert into user values(?,?)";
    //Emplyee
    public static final String FIND_EMPLOYEE_BY_NAME_OR_BY_ID="select * from employee where employee_name=? or employee_id=?";
    public static final String FIND_EMPLOYEE_BY_NAME="select * from employee where employee_name=? ";
    public static final String CREATE_EMPLOYEE="insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String DELETE_EMPLOYEE_BY_ID="delete from employee where employee_id=?";
    public static final String EDIT_EMPLOYEE="update employee set employee_name=?,employee_birthday=?,employee_id_card=?," +
            "employee_salary=? ,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?," +
            "division_id=?,username=? where employee_id=?";
    public static final String FIND_ALL_EMPLOYEE="select * from employee";
    public static final String FIND_EMPLOYEE_BY_ID="select * from employee where employee_id=?";
    //CustomerType
    public static final String FIND_ALL_CUSTOMERTYPE="select * from customer_type";
    public static final String FIND_CUSTOMERTYPE_BY_ID="select * from customer_type where customer_type_id=?";
    //Customer
    public static final String FIND_ALL_CUSTOMER="select * from customer";
    public static final String FIND_CUSTOMER_BY_ID="select * from customer where customer_id=?";
    public static final String CREATE_CUSTOMER="insert into customer values(?,?,?,?,?,?,?,?,?)";
    public static final String EDIT_CUSTOMER="update customer set customer_type_id=? ,customer_name=?,customer_birthday=?,customer_gender=?," +
            "customer_id_card=?,customer_phone=?,customer_email=?,customer_address where customer_id=?";
    public static final String DELETE_CUSTOMER_BY_ID="delete from customer where customer_id=?";
    //
    public static final String FIND_ALL_BY_ALL="select * from employee where employee_id like ? or employee_name like ? or employee_id_card like ? ";

}
