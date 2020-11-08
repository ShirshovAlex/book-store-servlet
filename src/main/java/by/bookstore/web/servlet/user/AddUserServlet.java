package by.bookstore.web.servlet.user;

import by.bookstore.entity.Address;
import by.bookstore.entity.Role;
import by.bookstore.entity.User;
import by.bookstore.service.UserService;
import by.bookstore.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/save")
public class AddUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/user/save.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String street = req.getParameter("street");

        userService.add(new User(name,login,pass,new Address(street), Role.MODERATOR));

        resp.sendRedirect("/");
    }
}
