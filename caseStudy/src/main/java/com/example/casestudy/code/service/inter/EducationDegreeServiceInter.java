package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.EducationDegree;

import java.util.List;

public interface EducationDegreeServiceInter {
    EducationDegree findEducationById(int id);
    List<EducationDegree> findALL();
}
