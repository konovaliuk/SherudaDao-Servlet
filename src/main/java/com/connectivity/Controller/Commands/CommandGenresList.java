package com.connectivity.Controller.Commands;

import com.connectivity.Controller.ConfigPath;
import com.connectivity.Controller.DTO.BookDto;
import com.connectivity.Controller.DTO.GenreDto;
import com.connectivity.Model.Entity.Book;
import com.connectivity.Service.BookService;
import com.connectivity.Service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class CommandGenresList implements ICommand{
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspAddress();
        Boolean registered = (Boolean) session.getAttribute("registered");
        System.out.println(registered);
        if(registered){
            ArrayList<GenreDto> genres = GenreService.getAllGenres();
            ArrayList<ArrayList<BookDto>> booksByGenres = new ArrayList<>();
            genres.forEach(x -> booksByGenres.add(GenreService.getBooksByGenre(x)));
            request.setAttribute("genres", genres);
            request.setAttribute("books", booksByGenres);
            return ConfigPath.genres.getJspAddress();
        }
        return ConfigPath.home.getJspAddress();
    }
}
