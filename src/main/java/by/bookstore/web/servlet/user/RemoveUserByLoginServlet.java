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

@WebServlet(urlPatterns = "/user/removeByLogin")
public class RemoveUserByLoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User[] all = userService.findAll();
        req.setAttribute("allUser", all);
        getServletContext().getRequestDispatcher("/pages/user/removeUserByLogin.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User byId = userService.findById(Integer.parseInt(id));
        userService.remove(byId);
        resp.sendRedirect("/");
    }
}
