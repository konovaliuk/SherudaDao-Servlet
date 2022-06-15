package com.connectivity.Service;

import com.connectivity.Controller.DTO.BookDto;
import com.connectivity.Controller.DTO.GenreDto;
import com.connectivity.Model.Dao.Dao;
import com.connectivity.Model.Entity.Book;
import com.connectivity.Model.Entity.Genre;
import com.connectivity.Model.Entity.JoinBookGenre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static Dao<Book> bookDao;
    private static Dao<JoinBookGenre> joinBookGenreDao;

    static {
        try {
            bookDao = (Dao<Book>) Dao.Builder.BuildDao(Book.class, false);
            joinBookGenreDao = (Dao<JoinBookGenre>) Dao.Builder.BuildDao(JoinBookGenre.class, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<BookDto> getAllBooks(){
        try {
            ArrayList<BookDto> bookDtos = new ArrayList<>();
            bookDao.findAll().forEach(x ->
                bookDtos.add(new BookDto(x.getId(), x.getName(), x.getYear()))
            );
            return bookDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static BookDto getBookById(Integer id) throws Exception {
        try {
            Book book = bookDao.findBy(new Book(id));
            return new BookDto(book.getId(),book.getName(),book.getYear());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        throw new Exception("Book not found!");
    }

    public static ArrayList<BookDto> searchBook(BookDto bookDto){
        try {
            ArrayList<BookDto> bookDtos = new ArrayList<>();
            bookDao.findAll().forEach(book ->{
                if (bookDto.name().equals(book.getName())||bookDto.date().equals(book.getYear())||bookDto.id().equals(book.getId())){
                    bookDtos.add(new BookDto(book.getId(), book.getName(), book.getYear()));
                }
            });
            return bookDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static Boolean createBook(BookDto bookDto){
        try {
            bookDao.create(new Book(bookDto.name(), bookDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean deleteBook(Integer id){
        try {
            bookDao.delete(new Book(id));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean updateBook(BookDto bookDto){
        try {
            bookDao.update(new Book(bookDto.id(), bookDto.name(), bookDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
