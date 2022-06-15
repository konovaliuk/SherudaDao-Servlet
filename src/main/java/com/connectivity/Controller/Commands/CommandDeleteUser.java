package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;
import com.connectivity.Controller.DTO.UserDto;
import com.connectivity.Service.BookService;
import com.connectivity.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteUser implements ICommand{

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspAddress();
        Boolean admin = (Boolean) session.getAttribute("admin");
        System.out.println(admin);
        if(admin) {
            System.out.println(request.getParameter("user_id"));
            UserService.deleteUser(Integer.parseInt(request.getParameter("user_id")));
            return Config.usersList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspAddress();
    }
}
