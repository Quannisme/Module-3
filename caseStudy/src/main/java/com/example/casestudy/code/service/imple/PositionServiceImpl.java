package com.example.casestudy.code.service.imple;

import com.example.casestudy.code.model.Position;
import com.example.casestudy.code.reponsitory.impl.PositionRepoImple;
import com.example.casestudy.code.reponsitory.inter.PositionRepoInter;
import com.example.casestudy.code.service.inter.PositionServiceInter;

import java.util.List;

public class PositionServiceImpl implements PositionServiceInter {
    PositionRepoInter postionRepo=new PositionRepoImple();
    @Override
    public Position findById(int id) {
        return postionRepo.findById(id) ;
    }

    @Override
    public List<Position> findAll() {
        return postionRepo.findAll();
    }
}
