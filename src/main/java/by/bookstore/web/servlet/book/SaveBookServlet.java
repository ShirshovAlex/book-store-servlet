package by.bookstore.web.servlet.book;

import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.entity.Category;
import by.bookstore.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/book/save")
public class SaveBookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author[] all = authorService.findAll();
        req.setAttribute("authors", all);
        req.setAttribute("categories", categoryService.findAll());
        getServletContext().getRequestDispatcher("/pages/book/saveBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tittle = req.getParameter("title");
        String description = req.getParameter("description");
        String authorId = req.getParameter("authorId");
        String categoryId = req.getParameter("categoryId");
        String price = req.getParameter("price");
        BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(price));

        Category byId1 = categoryService.findById(Integer.parseInt(categoryId));
        Author byId = authorService.findById(Integer.parseInt(authorId));


        Book book = new Book(tittle,description, byId, byId1, bigDecimal);
        bookService.save(book);
        resp.sendRedirect("/");
    }
}
