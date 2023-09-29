package code.service.inter;

import code.model.BenhNhan;

import java.util.List;

public interface BenhNhanSerInter {
    void add(BenhNhan benhNhan);
    List<BenhNhan> FindAll();
    void delete(String id);
    void update(BenhNhan benhNhan);
    BenhNhan findById(String id);
}
