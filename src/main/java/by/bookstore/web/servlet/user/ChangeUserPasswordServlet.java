package by.bookstore.web.servlet.user;

import by.bookstore.entity.User;
import by.bookstore.service.UserService;
import by.bookstore.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ChangeUserPasswordServlet",urlPatterns = "/user/changeUserPassword")
public class ChangeUserPasswordServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/user/changeUserPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("pass");
        User user = (User) req.getSession().getAttribute("user");
        userService.updatePassword(pass,user.getId());
        resp.sendRedirect("/user/account");
    }
}
