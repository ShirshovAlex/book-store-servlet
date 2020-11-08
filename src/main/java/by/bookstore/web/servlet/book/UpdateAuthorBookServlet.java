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

@WebServlet(urlPatterns = "/book/updateAuthorBook")
public class UpdateAuthorBookServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] all = bookService.findAll();
        req.setAttribute("allBook",all);
        getServletContext().getRequestDispatcher("/pages/book/updateAuthorBook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String author = req.getParameter("author");
        bookService.updateAuthorById(new Author(author),Integer.parseInt(id));
        resp.sendRedirect("/");
    }
}
