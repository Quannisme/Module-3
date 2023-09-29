package code.reponsitory.inter;

import code.model.BenhAn;

import java.util.List;

public interface BenhAnRepoInter {
    List<BenhAn> findAll();
    BenhAn findBenhAnById(String id);
}
