package by.bookstore.web.servlet.author;

import by.bookstore.entity.Author;
import by.bookstore.service.AuthorService;
import by.bookstore.service.AuthorServiceImpl;
import by.bookstore.web.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.DELETE_AUTHOR_BY_NAME_URL)
public class DeleteAuthorServlet extends HttpServlet {

    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author[] all = authorService.findAll();
        req.setAttribute("list", all);
        getServletContext().getRequestDispatcher(Constants.JSP_DELETE_AUTHOR_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        authorService.delete(Integer.parseInt(id));
        resp.sendRedirect("/");
    }
}
