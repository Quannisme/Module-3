package code.utill;

public class Constrain {
    //benh an
    public static final String FIND_ALL_BENH_AN="select * from benh_an";
    public static final String FIND_BENH_AN_BY_ID="select * from benh_an where id_benh_an=?";
    //benh nhan
    public static  final String FIND_ALL_BENH_NHAN="select * from benh_nhan";
    public static final String FIND_BENH_NHAN_BY_ID="select * from benh_nhan where id_benh_nhan=?";
    public static final String DELETE_BENH_NHAN_BY_ID="delete from benh_nhan where id_benh_nhan=?";
    public static final String CREATE_BENH_NHAN="insert into user values(?,?,?,?,?,?)";

}