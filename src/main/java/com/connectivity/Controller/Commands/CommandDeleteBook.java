package com.connectivity.Controller.Commands;

import com.connectivity.Controller.Config;
import com.connectivity.Controller.ConfigPath;
import com.connectivity.Service.BookService;
import com.connectivity.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteBook implements ICommand
{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspAddress();
        Boolean registered = (Boolean) session.getAttribute("registered");
        System.out.println(registered);
        if(registered) {
            System.out.println(request.getParameter("book_id"));
            BookService.deleteBook(Integer.parseInt(request.getParameter("book_id")));
            return Config.booksList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspAddress();
    }
}
