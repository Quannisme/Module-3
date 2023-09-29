package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.Division;

import java.util.List;

public interface DivisionServiceInter {
    Division findById(int id);
    List<Division> FindALL();
}
