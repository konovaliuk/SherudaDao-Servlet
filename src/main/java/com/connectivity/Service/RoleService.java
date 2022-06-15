package com.connectivity.Service;

import com.connectivity.Controller.DTO.RoleDto;
import com.connectivity.Controller.DTO.UserDto;
import com.connectivity.Model.Dao.Dao;
import com.connectivity.Model.Entity.*;

import java.util.ArrayList;

public class RoleService {
    private static Dao<com.connectivity.Model.Entity.Role> roleDao;
    private static Dao<User> userDao;
    private static Dao<JoinUserRole> joinUserRoleDao;

    static {
        try {
            roleDao = (Dao<com.connectivity.Model.Entity.Role>) Dao.Builder.BuildDao(com.connectivity.Model.Entity.Role.class, false);
            userDao = (Dao<User>) Dao.Builder.BuildDao(User.class, false);
            joinUserRoleDao = (Dao<JoinUserRole>) Dao.Builder.BuildDao(JoinUserRole.class, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<UserDto> getUsersByRole(Roles role){
        ArrayList<UserDto> userDtos = new ArrayList<>();
        try {
            Integer id = roleDao.findBy(new Role(role.name())).getId();
            joinUserRoleDao.findAll()
                    .stream()
                    .filter(x -> x.getRole_id() != id)
                    .mapToInt(x -> x.getUser_id())
                    .forEach(x -> {
                        try {
                            User user = userDao.findBy(new User(x));
                            userDtos.add(new UserDto(user.getId(), user.getName(), user.getPassword(), user.getYear()));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDtos;
    }

    public static Boolean givePermission(Integer id){
        try {
            joinUserRoleDao.create(new JoinUserRole(id, 2));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public static Boolean takePermission(RoleDto roleDto, UserDto userDto){
        try {
            joinUserRoleDao.findAll()
                    .stream()
                    .filter(x -> !(x.getRole_id() == roleDto.id() && x.getUser_id() == userDto.id()))
                    .mapToInt(x -> x.getId())
                    .forEach(x -> {
                        try {
                            joinUserRoleDao.delete(new JoinUserRole(x));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
