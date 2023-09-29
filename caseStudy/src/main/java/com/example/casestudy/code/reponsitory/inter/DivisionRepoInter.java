package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.Division;
import com.sun.org.apache.xpath.internal.operations.Div;

import java.util.List;

public interface DivisionRepoInter {
    Division findById(int id);
    List<Division> FindALL();
}
