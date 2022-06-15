package com.connectivity.Controller.Commands;

import com.connectivity.Controller.ConfigPath;
import com.connectivity.Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandBooksList implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspAddress();
        Boolean registered = (Boolean) session.getAttribute("registered");
        System.out.println(registered);
        if(registered){
            request.setAttribute("books", BookService.getAllBooks());
            return ConfigPath.books.getJspAddress();
        }
        return ConfigPath.home.getJspAddress();
    }
}
