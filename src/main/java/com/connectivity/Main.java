package com.connectivity;

import com.connectivity.Controller.DTO.RoleDto;
import com.connectivity.Controller.DTO.UserDto;
import com.connectivity.Model.Dao.Dao;
import com.connectivity.Model.Entity.*;
import com.connectivity.Service.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            Dao<Book> bookDao = (Dao<Book>) Dao.Builder.BuildDao(Book.class, false);
            Dao<JoinBookGenre> joinBookGenreDao = (Dao<JoinBookGenre>) Dao.Builder.BuildDao(JoinBookGenre.class, false);
            Dao<Genre> genreDao =  (Dao<Genre>) Dao.Builder.BuildDao(Genre.class, false);
            Dao<Role> roleDao = (Dao<Role>) Dao.Builder.BuildDao(Role.class, false);
            Dao<User>userDao = (Dao<User>) Dao.Builder.BuildDao(User.class, false);
            Dao<JoinUserRole>joinUserRoleDao = (Dao<JoinUserRole>) Dao.Builder.BuildDao(JoinUserRole.class, false);

//            roleDao.create(new Role("user"));
//            roleDao.create(new Role("admin"));
//            Date today = new Date();
//            userDao.create(new User("user1", "pass1", new java.sql.Date(today.getTime())));
//            userDao.create(new User("user2", "pass1", new java.sql.Date(today.getTime())));
//            joinUserRoleDao.create(new JoinUserRole(1,1));
//            joinUserRoleDao.create(new JoinUserRole(2,2));
//            RoleService.givePermission(new RoleDto(2, "admin"), new UserDto(1,null,null, null));
        } catch (Exception e) {
                e.printStackTrace();
        }

    }
}
