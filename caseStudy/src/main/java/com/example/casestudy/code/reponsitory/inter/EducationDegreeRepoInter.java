package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.EducationDegree;

import java.util.List;

public interface EducationDegreeRepoInter {
    EducationDegree findEducationById(int id);
    List<EducationDegree> findALL();
}
