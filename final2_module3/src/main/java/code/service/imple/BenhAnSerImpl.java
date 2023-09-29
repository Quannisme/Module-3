package code.service.imple;

import code.model.BenhAn;
import code.reponsitory.imple.BenhAnRepoImpl;
import code.reponsitory.inter.BenhAnRepoInter;

import java.util.List;

public class BenhAnSerImpl implements BenhAnRepoInter {
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
