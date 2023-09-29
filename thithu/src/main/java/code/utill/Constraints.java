package code.utill;

public class Constraints {
    //user
    public static final String CREATE_USER="insert into userr values(?,?,?,?,?)";
    public static final String FIND_ALL_USER="select * from userr";
    public static final String FIND_USER_BY_ID="select * from userr where user_id=?";
    public static final String DELETE_USER_BY_ID="delete from userr where user_id=?";
    public static final String UPDATE_USER_BY_ID="update userr set user_name=?,user_code=?,user_birthday=?,user_daterelease=? where user_id=?";
    //role
    public static final String FIND_ALL_ROLE="select * from rolee";
    public static final String FIND_ROLE_BY_ID="select * from rolee where role_id=?";
    public static final String FIND_ROLES_BY_USERID = "select r.* from rolee r inner join user_role u on r.role_id = u.role_id " +
            "where u.user_id = ?";
    //userRole
    public static final String CREATE_USERROLE="insert into user_role value(?,?)";
    public static final String DELETE_USERROLE="delete from user_role  where user_id =?";
    public static final String UPDATE_USERROLE="update user_role set user_id = ?,role_id=? where user_id=?";
    public static final String SHOW_ALL_BY_ID="SELECT userr.*, rolee.role_name\n" +
            "FROM userr\n" +
            "JOIN user_role ON userr.user_id = user_role.user_id\n" +
            "JOIN rolee ON user_role.role_id = rolee.role_id\n" +
            "WHERE userr.user_id like ? or userr.user_name like ? or userr.user_code like ? or role_name like ? ";

    public static final String FIND_ALL_USERROLE="SELECT userr. * ,GROUP_CONCAT(role_name SEPARATOR ' ') as role_name\n" + "FROM user_role\n" + "join rolee USING(role_id)\n" + "join userr using(user_id)\n" + "GROUP BY user_id;";
}
