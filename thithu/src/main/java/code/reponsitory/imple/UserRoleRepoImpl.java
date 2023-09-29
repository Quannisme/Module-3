package code.reponsitory.imple;

import code.modell.Role;
import code.modell.User;
import code.modell.UserRole;
import code.reponsitory.inter.UserRoleRepoInter;
import code.utill.Constraints;
import code.utill.DatabaseConnection;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRoleRepoImpl implements UserRoleRepoInter {
    @Override
    public List<Role> findAllRole() {
        List<Role> res = new ArrayList<>();

        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ALL_ROLE)
        ) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int roleId = resultSet.getInt(1);
                String roleName = resultSet.getString(2);
                res.add(new Role(roleId, roleName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public List<UserRole> findAll() {
        List<UserRole>userRoles=new ArrayList<>();
        try (Connection connection= DatabaseConnection.getConnection();
             PreparedStatement statement=connection.prepareStatement(Constraints.FIND_ALL_USERROLE);){
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                String idUser = resultSet.getString("user_id");
                String fullName = resultSet.getString("user_name");
                String code = resultSet.getString("user_code");
                Date birthday = new Date(resultSet.getDate("user_birthday").getTime());
                Date dateRelease = new Date(resultSet.getDate("user_daterelease").getTime());
                Role role = new Role();
                role.setName(resultSet.getString("role_name"));
                user = new User(idUser, fullName, code, birthday, dateRelease,null);
                userRoles.add(new UserRole(user, role));
                System.out.println(birthday+" "+dateRelease);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userRoles;
    }

    @Override
    public User findById(String idUser) {
        UserRole userRole = null;
        PreparedStatement statement =null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(Constraints.FIND_USER_BY_ID);
            statement.setString(1,idUser);
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()){
                int id_user = resultSet.getInt("user_id");
                String fullName = resultSet.getString("user_name");
                String code = resultSet.getString("user_code");
                Date birth = new Date(resultSet.getDate("user_birthday").getTime());
                Date startDate = new Date(resultSet.getDate("user_daterelease").getTime());
                user = new User(idUser, fullName, code, birth, startDate, findRoleByUserId(id_user));
                return user;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
    private List<Role> findRoleByUserId(int id_user) {
        List<Role> roles = new ArrayList<>();
        try (
                Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(Constraints.FIND_ROLES_BY_USERID)
        ) {
            statement.setInt(1, id_user);
            ResultSet resultSet = statement.executeQuery();
            Role role;
            while (resultSet.next()) {
                int idRole = resultSet.getInt("role_id");
                String roleName = resultSet.getString("role_name");
                role = new Role(idRole, roleName);
                roles.add(role);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }

    @Override
    public void remove(String idUser) {
        PreparedStatement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
        ) {
            statement = connection.prepareStatement(Constraints.DELETE_USERROLE);
            statement.setString(1, idUser);
            statement.executeUpdate();

            statement = connection.prepareStatement(Constraints.DELETE_USER_BY_ID);
            statement.setString(1, idUser);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User userRole) {
        PreparedStatement statement=null;
        try (Connection connection= DatabaseConnection.getConnection();){
            statement=connection.prepareStatement(Constraints.UPDATE_USER_BY_ID);
            statement.setString(1, userRole.getName());
            statement.setString(2, userRole.getCode());
            statement.setDate(3, new java.sql.Date(userRole.getBirthday().getTime()));
            statement.setDate(4, new java.sql.Date(userRole.getDateRelease().getTime()));
            statement.setString(5, userRole.getId());
            statement.executeUpdate();
            removeUserRoleByUserId(userRole.getId());
            for(Role role: userRole.getRole()) {
                statement = connection.prepareStatement(Constraints.CREATE_USERROLE);
                statement.setString(1, userRole.getId());
                statement.setInt(2,role.getId());
                statement.executeUpdate();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<UserRole> showBy(String name, String id, String code, String role_name) {
        List<UserRole> userRole = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.prepareStatement(Constraints.SHOW_ALL_BY_ID);
            statement.setString(1, "%" + name + "%");
            statement.setString(2, "%" + id + "%");
            statement.setString(3, "%" + code + "%");
            statement.setString(4, "%" + role_name + "%");
            ResultSet resultSet = statement.executeQuery();
            User user;
            while (resultSet.next()) {
                id= resultSet.getString("user_id");
                name = resultSet.getString("user_name");
                code = resultSet.getString("user_code");
                java.util.Date birthDate=new java.util.Date(resultSet.getDate("user_birthday").getTime());
                java.util.Date daterelease=new java.util.Date(resultSet.getDate("user_daterelease").getTime());
                Role role = new Role();
                role.setName(resultSet.getString("role_name"));
                user = new User(id, name, code, birthDate, daterelease, null);
                userRole.add(new UserRole(user, role));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return userRole;
    }

    @Override
    public void add(User user) {
        PreparedStatement statement=null;
        try (Connection connection=DatabaseConnection.getConnection();){
              statement=connection.prepareStatement(Constraints.CREATE_USER);
            statement.setString(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getCode());
            statement.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
            statement.setDate(5, new java.sql.Date(user.getDateRelease().getTime()));
            statement.executeUpdate();

            for(Role role : user.getRole()){
                statement=connection.prepareStatement(Constraints.CREATE_USERROLE);
                statement.setString(1, user.getId());
                statement.setInt(2, role.getId());
                statement.executeUpdate();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean removeUserRoleByUserId(String idUser) {
        PreparedStatement statement = null;
        try (Connection connection = DatabaseConnection.getConnection();
        ) {
            statement = connection.prepareStatement(Constraints.DELETE_USERROLE);
            statement.setString(1, idUser);
            statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
