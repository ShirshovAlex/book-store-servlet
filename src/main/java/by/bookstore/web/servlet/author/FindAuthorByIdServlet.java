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

@WebServlet(urlPatterns = Constants.FIND_AUTHOR_BY_ID_URL)
public class FindAuthorByIdServlet extends HttpServlet {

    private AuthorService authorService = new AuthorServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constants.JSP_FIND_AUTHOR_BY_ID_PATH).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Author byId = authorService.findById(Integer.parseInt(id));
        req.setAttribute("idAuthor",byId);

        getServletContext().getRequestDispatcher("/pages/author/findAuthorById.jsp").forward(req,resp);

    }
}
