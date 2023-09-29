package code.service.impl;

import code.model.BenhNhan;
import code.reponsitory.impl.BenhNhanRepoImpl;
import code.reponsitory.inter.BenhNhanRepoInter;
import code.service.inter.BenhNhanSerInter;

import java.util.List;

public class BenhNhanSerImpl implements BenhNhanSerInter{
    private BenhNhanRepoInter benhNhanRepoInter=new BenhNhanRepoImpl();

    @Override
    public void add(BenhNhan benhNhan) {
        benhNhanRepoInter.add(benhNhan);
    }

    @Override
    public List<BenhNhan> FindAll() {
        return benhNhanRepoInter.FindAll();
    }

    @Override
    public void delete(String id) {
        benhNhanRepoInter.delete(id);
    }

    @Override
    public void update(BenhNhan benhNhan) {
        benhNhanRepoInter.update(benhNhan);
    }

    @Override
    public BenhNhan findById(String id) {
        return benhNhanRepoInter.findById(id);
    }
}
