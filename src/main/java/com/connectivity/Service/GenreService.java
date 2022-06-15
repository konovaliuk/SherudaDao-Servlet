package com.connectivity.Service;

import com.connectivity.Controller.DTO.BookDto;
import com.connectivity.Controller.DTO.GenreDto;
import com.connectivity.Model.Dao.Dao;
import com.connectivity.Model.Entity.Book;
import com.connectivity.Model.Entity.Genre;
import com.connectivity.Model.Entity.JoinBookGenre;


import java.util.ArrayList;

public class GenreService {
    private static Dao<Genre> genreDao;
    private static Dao<Book> bookDao;
    private static Dao<JoinBookGenre> joinBookGenreDao;

    static {
        try {
            genreDao = (Dao<Genre>) Dao.Builder.BuildDao(Genre.class, false);
            bookDao = (Dao<Book>) Dao.Builder.BuildDao(Book.class, false);
            joinBookGenreDao = (Dao<JoinBookGenre>) Dao.Builder.BuildDao(JoinBookGenre.class, false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<GenreDto> getAllGenres(){
        try {
            ArrayList<GenreDto> genreDtos = new ArrayList<>();
            genreDao.findAll().forEach(x ->
                    genreDtos.add(new GenreDto(x.getId(), x.getName(), x.getYear()))
            );
            return genreDtos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static Boolean addGenre(GenreDto genreDto){
        try {
            genreDao.create(new Genre(genreDto.name(), genreDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean deleteGenre(GenreDto genreDto){
        try {
            genreDao.delete(new Genre(genreDto.id(), genreDto.name(), genreDto.date()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ArrayList<BookDto> getBooksByGenre(GenreDto genreDto){
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        try {
            Integer id = genreDao.findBy(new Genre(genreDto.name())).getId();
            joinBookGenreDao.findAll()
                    .stream()
                    .filter(x -> x.getGenre_id() != id)
                    .mapToInt(x -> x.getBook_id())
                    .forEach(x -> {
                        try {
                            Book book = bookDao.findBy(new Book(x));
                            bookDtos.add(new BookDto(book.getId(), book.getName(), book.getYear()));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookDtos;
    }

    public static Boolean setGenreForBook(GenreDto genreDto, BookDto bookDto){
        try {
            joinBookGenreDao.create(new JoinBookGenre(bookDto.id(), genreDto.id()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public static Boolean deleteGenreFromBook(GenreDto genreDto, BookDto bookDto){
        try {
            joinBookGenreDao.findAll()
                    .stream()
                    .filter(x -> !(x.getGenre_id() == genreDto.id() && x.getBook_id() == bookDto.id()))
                    .mapToInt(x -> x.getId())
                    .forEach(x -> {
                        try {
                            joinBookGenreDao.delete(new JoinBookGenre(x));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
