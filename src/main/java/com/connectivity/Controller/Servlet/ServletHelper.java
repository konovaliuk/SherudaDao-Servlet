package com.connectivity.Controller.Servlet;

import com.connectivity.Controller.Commands.ICommand;
import com.connectivity.Controller.Config;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {
    public static ICommand getCommand(HttpServletRequest request){
        String name = request.getParameter("command");
        if(name == null) return Config.home.getCommand();
        try{
            return Config.valueOf(name).getCommand();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return Config.home.getCommand();
    }
}
