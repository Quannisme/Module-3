package com.example.casestudy.code.validate;

import com.example.casestudy.code.service.imple.EmployeeServiceImpl;
import com.example.casestudy.code.service.inter.EmployeeServiceInter;

public class EmployeeValidate {
    private EmployeeServiceInter employeeService=new EmployeeServiceImpl();
    //sdt
    private static final String PHONE_FORMAT="^[0]9[01][0-9]{7}$";
    public  boolean isPhone(String Phone)
    {
        return Phone.matches(PHONE_FORMAT);
    }
    //cmnd
    private static final String CMND_FORMAT="^\\d{9}$|^\\d{12}$";
    public boolean isCmnd(String cmnd){return cmnd.matches(CMND_FORMAT);}
    //email
    private static final String EMAIL_FORMAT="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public boolean isEmail(String email){return email.matches(EMAIL_FORMAT);}
    //nameEmployeeViDu
    private static final String NAME_FORMAT="^KH-\\d{4}$";
    public boolean isName(String name){return name.matches(EMAIL_FORMAT);}
}
