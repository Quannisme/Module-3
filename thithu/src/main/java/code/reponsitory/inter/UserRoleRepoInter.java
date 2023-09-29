package code.reponsitory.inter;

import code.modell.Role;
import code.modell.User;
import code.modell.UserRole;

import java.sql.SQLException;
import java.util.List;

public interface UserRoleRepoInter {
    List<UserRole> findAll();
    User findById(String idUser);
    void remove(String idUser);
    void update(User userRole);
    void add(User user);
    List<Role>findAllRole();
    List<UserRole> showBy(String name , String id , String code ,String role_name );
}
