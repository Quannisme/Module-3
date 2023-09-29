package code.model;

import java.util.Date;

public class BenhNhan {
    private String id;
    private String name;
    private Date in;
    private Date out;
    private String lyDo;
    private BenhAn benhAn;

    public BenhNhan() {
    }

    public BenhNhan(String id, String name, Date in, Date out, String lyDo, BenhAn benhAn) {
        this.id = id;
        this.name = name;
        this.in = in;
        this.out = out;
        this.lyDo = lyDo;
        this.benhAn = benhAn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public BenhAn getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(BenhAn benhAn) {
        this.benhAn = benhAn;
    }
}
