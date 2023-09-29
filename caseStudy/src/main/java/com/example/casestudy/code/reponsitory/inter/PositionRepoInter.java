package com.example.casestudy.code.reponsitory.inter;

import com.example.casestudy.code.model.Position;

import java.util.List;

public interface PositionRepoInter {
    Position findById(int id);
    List<Position> findAll();
}
