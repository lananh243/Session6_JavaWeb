package com.data.session06_javaweb.ra.controller;

import com.data.session06_javaweb.ra.model.Book;
import com.data.session06_javaweb.ra.service.BookService;
import com.data.session06_javaweb.ra.service.BookServiceImp;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "BookController", value = "/books")
public class BookController extends HttpServlet {
    private final BookService bookService;

    public BookController() {
        bookService = new BookServiceImp();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("views/login.jsp");
            return;
        }
        String action = request.getParameter("action");
        if (action.equals("getAll")) {
            findAllBook(request,response);
        } else if (action.equals("update")) {
            int bookId =  Integer.parseInt(request.getParameter("bookId"));
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                request.setAttribute("book", book);
                request.getRequestDispatcher("views/updateBook.jsp").forward(request, response);
            }
        } else if (action.equals("delete")) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            boolean result = bookService.deleteBook(bookId);
            if (result) {
                findAllBook(request,response);
            }
        } else if (action.equals("search")) {
            String valueTitle =  request.getParameter("valueTitle");
            List<Book> listBooks = bookService.searchBookByTitle(valueTitle);
            request.setAttribute("listBooks", listBooks);
            request.getRequestDispatcher("views/books.jsp").forward(request, response);

        }
    }

    public void findAllBook(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Book> listBooks = bookService.getAll();
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("views/books.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("Create")) {
            Book book = new Book();
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setCategory(request.getParameter("category"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            boolean result = bookService.addBook(book);
            if (result) {
                findAllBook(request,response);
            }
        } else if (action.equals("Update")) {
            Book book = new Book();
            book.setBookId(Integer.parseInt(request.getParameter("bookId")));
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setCategory(request.getParameter("category"));
            book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
            boolean result = bookService.updateBook(book);
            if (result) {
                findAllBook(request,response);
            }
        }
    }
}