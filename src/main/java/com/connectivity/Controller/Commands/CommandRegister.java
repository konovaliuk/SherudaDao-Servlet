package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;
import com.connectivity.Controller.DTO.UserDto;
import com.connectivity.Service.RoleService;
import com.connectivity.Service.Roles;
import com.connectivity.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;


public class CommandRegister implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        java.util.Date today = new java.util.Date();
        UserDto user = new UserDto(null, username, password, new java.sql.Date(today.getTime()));
        if(UserService.isUserUnique(username))
            UserService.createUser(user);
        else {
            request.setAttribute("unique", false);
            return ConfigPath.register.getJspAddress();
        }
        request.setAttribute("unique", true);
        session.setAttribute("registered", true);
        session.setAttribute("user", user);
        session.setAttribute("admin", false);
        return ConfigPath.home.getJspAddress();
    }
}
