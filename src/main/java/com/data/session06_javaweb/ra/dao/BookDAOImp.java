package com.data.session06_javaweb.ra.dao;

import com.data.session06_javaweb.ra.model.Book;
import com.data.session06_javaweb.ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp implements  BookDAO {
    @Override
    public List<Book> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> books = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_book()}");
            ResultSet rs = callSt.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setCategory(rs.getString("book_category"));
                book.setQuantity(rs.getInt("book_quantity"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return books;
    }

    @Override
    public boolean addBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_book(?,?,?,?)}");
            callSt.setString(1, book.getTitle());
            callSt.setString(2, book.getAuthor());
            callSt.setString(3, book.getCategory());
            callSt.setInt(4, book.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Book getBookById(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_book_by_id(?)}");
            callSt.setInt(1, bookId);
            ResultSet rs = callSt.executeQuery();
            book = new Book();
            if (rs.next()) {
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setCategory(rs.getString("book_category"));
                book.setQuantity(rs.getInt("book_quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean updateBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?,?)}");
            callSt.setInt(1, book.getBookId());
            callSt.setString(2, book.getTitle());
            callSt.setString(3, book.getAuthor());
            callSt.setString(4, book.getCategory());
            callSt.setInt(5, book.getQuantity());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean deleteBook(int bookId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");
            callSt.setInt(1, bookId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> books = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_book_by_title(?)}");
            callSt.setString(1, title);
            ResultSet rs = callSt.executeQuery();
            books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("book_title"));
                book.setAuthor(rs.getString("book_author"));
                book.setCategory(rs.getString("book_category"));
                book.setQuantity(rs.getInt("book_quantity"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return books;
    }
}
