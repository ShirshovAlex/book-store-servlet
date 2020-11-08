package by.bookstore.web.servlet.author;

import by.bookstore.entity.Author;
import by.bookstore.service.AuthorService;
import by.bookstore.service.AuthorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/findAuthorByName")
public class FindAuthorByNameServlet extends HttpServlet {

    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/author/findAuthorByName.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Author[] byName = authorService.findByName(name);
        req.setAttribute("byName",byName);
        getServletContext().getRequestDispatcher("/pages/author/findAuthorByName.jsp").forward(req,resp);

    }
}
