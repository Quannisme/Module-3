package com.example.casestudy.code.service.inter;

import com.example.casestudy.code.model.Position;

import java.util.List;

public interface PositionServiceInter {
    Position findById(int id);
    List<Position> findAll();
}
