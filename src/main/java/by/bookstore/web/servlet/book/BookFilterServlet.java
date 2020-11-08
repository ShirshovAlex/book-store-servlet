package by.bookstore.web.servlet.book;

import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;
import by.bookstore.service.CategoryService;
import by.bookstore.service.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/filter")
public class BookFilterServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] ids = bookService.findAllByCategoryId(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("books", ids);
        req.setAttribute("categories", categoryService.findAll());
        getServletContext().getRequestDispatcher("/pages/book/filter.jsp").forward(req, resp);
    }
}
