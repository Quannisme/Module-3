package code.reponsitory.inter;

import code.model.BenhNhan;

import java.util.List;

public interface BenhNhanRepoInter {
    void add(BenhNhan benhNhan);
    List<BenhNhan> FindAll();
    void delete(String id);
    void update(BenhNhan benhNhan);
    BenhNhan findById(String id);
}
