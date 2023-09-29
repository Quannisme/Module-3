package code.service.inter;

import code.model.BenhAn;

import java.util.List;

public interface BenhAnSerInter {
    List<BenhAn> findAll();
    BenhAn findBenhAnById(String id);
}
