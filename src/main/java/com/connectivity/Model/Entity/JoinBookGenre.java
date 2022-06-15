package com.connectivity.Model.Entity;

import com.connectivity.Model.Dao.Markers.*;

@Entity(tableName = "books_genres")
@JoinTable
public class JoinBookGenre {
    @Id
    @Column(columnName = "ID",isNotNull = true, isAutoIncrement = true)
    private Integer id;

    @JoinField(referencedClass = Book.class, columnName = "ID", onDelete = JoinField.OnDelete.CASCADE)
    @Column(columnName = "book_id",isNotNull = true)
    Integer book_id;

    @JoinField(referencedClass = Genre.class, columnName = "ID", onDelete = JoinField.OnDelete.CASCADE)
    @Column(columnName = "genre_id",isNotNull = true)
    Integer genre_id;

    public JoinBookGenre(Integer book_id, Integer genre_id) {
        this.book_id = book_id;
        this.genre_id = genre_id;
    }

    public JoinBookGenre() {
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public Integer getId() {
        return id;
    }

    public JoinBookGenre(Integer id) {
        this.id = id;
    }
}
