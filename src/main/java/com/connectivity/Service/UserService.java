package com.connectivity.Service;

import com.connectivity.Controller.DTO.BookDto;
import com.connectivity.Controller.DTO.UserDto;
import com.connectivity.Model.Dao.Dao;
import com.connectivity.Model.Entity.Book;
import com.connectivity.Model.Entity.JoinBookGenre;
import com.connectivity.Model.Entity.User;

import java.util.ArrayList;

public class UserService {
    private static Dao<User> userDao;

    static {
        try {
            userDao = (Dao<User>) Dao.Builder.BuildDao(User.class, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<UserDto> getAllUsers(){
        try {
            ArrayList<UserDto> userDtos = new ArrayList<>();
            userDao.findAll().forEach(x ->
                    userDtos.add(new UserDto(x.getId(), x.getName(),x.getPassword(), x.getYear()))
            );
            return userDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static UserDto getUserById(Integer id) throws Exception {
        try {
            User user = userDao.findBy(new User(id));
            return new UserDto(user.getId(),user.getName(), user.getPassword(),user.getYear());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        throw new Exception("User not found!");
    }

    public static ArrayList<UserDto> searchUser(UserDto userDto){
        try {
            ArrayList<UserDto> userDtos = new ArrayList<>();
            userDao.findAll().forEach(user ->{
                if (userDto.name().equals(user.getName())||userDto.date().equals(user.getYear())||userDto.id().equals(user.getId())){
                    userDtos.add(new UserDto(user.getId(), user.getName(), user.getPassword(), user.getYear()));
                }
            });
            return userDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static Boolean createUser(UserDto userDto){
        try {
            userDao.create(new User(userDto.id(), userDto.name(), userDto.password(), userDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean deleteUser(Integer id){
        try {
            userDao.delete(new User(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean updateUser(UserDto userDto){
        try {
            userDao.update(new User(userDto.id(), userDto.name(), userDto.password(), userDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserDto isUserRegistered(String name, String password){
        try {
            for(User user : userDao.findAll()){
                if (name.equals(user.getName())||password.equals(user.getPassword()))
                    return new UserDto(user.getId(), user.getName(), user.getPassword(), user.getYear());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean isUserUnique(String name){
        try {
            for(User user : userDao.findAll()){
                if (name.equals(user.getName()))
                    return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
