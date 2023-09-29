package code.service.impl;

import code.model.BenhAn;
import code.reponsitory.impl.BenhAnRepoImpl;
import code.reponsitory.inter.BenhAnRepoInter;
import code.service.inter.BenhAnSerInter;

import java.util.List;

public class BenhAnSerImpl implements BenhAnSerInter {
    private BenhAnRepoInter benhAnRepoInter=new BenhAnRepoImpl();

    @Override
    public List<BenhAn> findAll() {
        return benhAnRepoInter.findAll();
    }

    @Override
    public BenhAn findBenhAnById(String id) {
        return benhAnRepoInter.findBenhAnById(id);
    }
}
