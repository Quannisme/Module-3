package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.Division;
import com.example.casestudy.code.reponsitory.impl.DivisionRepoImple;
import com.example.casestudy.code.reponsitory.inter.DivisionRepoInter;
import com.example.casestudy.code.service.inter.DivisionServiceInter;

import java.util.List;

public class DivisionServiceImpl implements DivisionServiceInter {
    DivisionRepoInter divisionRepo =new DivisionRepoImple();
    @Override
    public Division findById(int id) {
        return divisionRepo.findById(id);
    }

    @Override
    public List<Division> FindALL() {
        return divisionRepo.FindALL();
    }
}
