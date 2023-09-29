package code.service.inter;

import code.modell.Role;
import code.modell.User;
import code.modell.UserRole;

import java.util.List;

public interface UserRoleServiceInter {
    List<UserRole> findAll();
    User findById(String idUser);
    void remove(String idUser);
    void update(User userRole);
    void add(User user);
    List<Role>findAllRole();
    List<UserRole> showBy(String name , String id , String code ,String role_name );
}
