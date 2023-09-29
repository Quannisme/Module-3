package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.EducationDegree;
import com.example.casestudy.code.reponsitory.impl.EducationDegreeRepoImple;
import com.example.casestudy.code.reponsitory.inter.EducationDegreeRepoInter;
import com.example.casestudy.code.service.inter.EducationDegreeServiceInter;

import java.util.List;

public class EducationDegreeServiceImpl implements EducationDegreeServiceInter {
    EducationDegreeRepoInter educationDegreeRepo =new EducationDegreeRepoImple();

    @Override
    public EducationDegree findEducationById(int id) {
        return educationDegreeRepo.findEducationById(id);
    }

    @Override
    public List<EducationDegree> findALL() {
        return educationDegreeRepo.findALL();
    }
}
