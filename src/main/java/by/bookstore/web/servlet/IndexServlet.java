package by.bookstore.web.servlet;

import by.bookstore.entity.Book;
import by.bookstore.entity.Category;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;
import by.bookstore.service.CategoryService;
import by.bookstore.service.CategoryServiceImpl;
import by.bookstore.web.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] all = bookService.findAll();
        Category[] all1 = categoryService.findAll();
        req.setAttribute("categories", all1);
        req.setAttribute("books", all);
        getServletContext().getRequestDispatcher(Constants.JSP_INDEX_PATH).forward(req, resp);
    }
}
