package code.service.imple;

import code.modell.Role;
import code.modell.User;
import code.modell.UserRole;
import code.reponsitory.imple.UserRoleRepoImpl;
import code.reponsitory.inter.UserRoleRepoInter;
import code.service.inter.UserRoleServiceInter;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleServiceInter {
    UserRoleRepoInter userRoleRepo=new UserRoleRepoImpl();
    @Override
    public List<UserRole> findAll() {
        return userRoleRepo.findAll();
    }

    @Override
    public User findById(String idUser) {
        return userRoleRepo.findById(idUser);
    }

    @Override
    public List<UserRole> showBy(String name , String id , String code ,String role_name) {
        return userRoleRepo.showBy(name,id,code,role_name);
    }

    @Override
    public List<Role> findAllRole() {
        return userRoleRepo.findAllRole();
    }

    @Override
    public void remove(String idUser) {
        userRoleRepo.remove(idUser);
    }

    @Override
    public void update(User userRole) {
        userRoleRepo.update(userRole);
    }

    @Override
    public void add(User user) {
    userRoleRepo.add(user);
    }
}
