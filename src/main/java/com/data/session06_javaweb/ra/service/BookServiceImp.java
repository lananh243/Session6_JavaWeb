package com.data.session06_javaweb.ra.service;

import com.data.session06_javaweb.ra.dao.BookDAO;
import com.data.session06_javaweb.ra.dao.BookDAOImp;
import com.data.session06_javaweb.ra.model.Book;

import java.util.List;

public class BookServiceImp implements  BookService {
    private final BookDAO bookDAO;

    public BookServiceImp() {
        bookDAO = new BookDAOImp();
    }


    @Override
    public List<Book> getAll() {
        return bookDAO.getAll();
    }

    @Override
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookDAO.getBookById(bookId);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public boolean deleteBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return bookDAO.searchBookByTitle(title);
    }
}
