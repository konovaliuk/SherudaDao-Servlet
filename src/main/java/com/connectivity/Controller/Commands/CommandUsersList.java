package com.connectivity.Controller.Commands;

import com.connectivity.Controller.ConfigPath;
import com.connectivity.Service.BookService;
import com.connectivity.Service.RoleService;
import com.connectivity.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandUsersList implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspAddress();
        Boolean admin = (Boolean) session.getAttribute("admin");
        System.out.println(admin);
        if(admin){
            request.setAttribute("users", UserService.getAllUsers());
            return ConfigPath.users.getJspAddress();
        }
        return ConfigPath.home.getJspAddress();
    }
}
