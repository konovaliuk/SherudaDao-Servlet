package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;
import com.connectivity.Controller.DTO.BookDto;
import com.connectivity.Service.BookService;
import com.connectivity.Service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

public class CommandAddBook implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspAddress();
        Boolean registered = (Boolean) session.getAttribute("registered");
        java.util.Date today = new java.util.Date();
        if(registered) {
            BookService.createBook( new BookDto(
                    null,
                    request.getParameter("name"),
                    new java.sql.Date(today.getTime())));
            return Config.booksList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspAddress();
    }
}
