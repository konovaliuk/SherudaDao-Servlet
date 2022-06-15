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

public class CommandLogin implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDto user = UserService.isUserRegistered(username, password);
        if(user != null){
            session.setAttribute("registered", true);
            session.setAttribute("user", user);
            if(RoleService.getUsersByRole(Roles.admin).contains(user))
                session.setAttribute("admin", true);
            else session.setAttribute("admin", false);
            return ConfigPath.home.getJspAddress();
        }
        else request.setAttribute("incorrect", true);
        session.setAttribute("registered", false);
        return ConfigPath.login.getJspAddress();
    }
}
