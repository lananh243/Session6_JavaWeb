package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getAll();
    boolean addBook(Book book);
    Book getBookById(int bookId);
    boolean updateBook(Book book);
    boolean deleteBook(int bookId);
    List<Book> searchBookByTitle(String title);
}
