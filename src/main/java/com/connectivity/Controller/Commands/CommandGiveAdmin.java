package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;
import com.connectivity.Service.RoleService;
import com.connectivity.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandGiveAdmin implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspAddress();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            RoleService.givePermission(Integer.parseInt(request.getParameter("user_id")));
            return Config.usersList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspAddress();
    }
}
