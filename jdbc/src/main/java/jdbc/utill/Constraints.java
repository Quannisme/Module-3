package jdbc.utill;

public class Constraints {
    public static final String FIND_ALL_USER="select * from users";
    public static final String FIND_USER_BY_ID="select * from users where id=?";
    public static final String FIND_USER_BY_Country="select * from users where country=?";
    public static final String DELETE_USER_BY_ID="delete from users where id=?";
    public static final String UPDATE_USER="update users set name=?,email=?,country=? where id=?";
    public static final String CREATE_USER="insert into users (name,email,country) values(?,?,?)";
    public static final String SORT_BY_NAME="SELECT * FROM users ORDER BY name";
    //procedure
    public static final String DELETE_USER_BY_ID_PROCEDURE="{call delete_record_by_id(?)}";

}
