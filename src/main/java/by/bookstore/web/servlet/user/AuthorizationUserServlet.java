package by.bookstore.web.servlet.user;

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

@WebServlet(name = "AuthorizationUserServlet", urlPatterns = "/user/authorization")
public class AuthorizationUserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User byLogin = userService.findByLogin(login);
        if (byLogin != null) {
            if (byLogin.getPassword().equals(pass)) {
                if (byLogin.getRole().equals(Role.USER)) {
                    req.getSession().setAttribute("isUser", true);
                } else if (byLogin.getRole().equals(Role.ADMIN)) {
                    req.getSession().setAttribute("isAdmin", true);
                }
                req.getSession().setAttribute("isGuest", false);
                req.getSession().setAttribute("user", byLogin);
                resp.sendRedirect("/");
                return;
            } else {
                req.setAttribute("message", "Wrong password");
            }
        } else {
            req.setAttribute("message", "User not found");
        }
        getServletContext().getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }
}
