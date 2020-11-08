package by.bookstore.web.servlet.book;

import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/findByAuthor")
public class FindBookByAuthorServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/book/findByAuthor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        Book[] allByAuthor = bookService.findAllByAuthor(new Author(author));
        req.setAttribute("byAuthor",allByAuthor);
        getServletContext().getRequestDispatcher("/pages/book/findByAuthor.jsp").forward(req,resp);
    }
}
