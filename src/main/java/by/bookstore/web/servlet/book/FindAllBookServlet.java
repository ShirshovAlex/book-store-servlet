package by.bookstore.web.servlet.book;

import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/findAll")
public class FindAllBookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] all = bookService.findAll();
        req.setAttribute("findAll", all);
        getServletContext().getRequestDispatcher("/pages/book/findAll.jsp").forward(req,resp);
    }
}
