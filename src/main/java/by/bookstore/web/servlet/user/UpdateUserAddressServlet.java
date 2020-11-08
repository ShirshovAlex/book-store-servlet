package by.bookstore.web.servlet.user;

import by.bookstore.entity.Address;
import by.bookstore.entity.User;
import by.bookstore.service.UserService;
import by.bookstore.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateUserAddressServlet",urlPatterns = "/user/updateAddress")
public class UpdateUserAddressServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User[] all = userService.findAll();
        req.setAttribute("allUser", all);
        getServletContext().getRequestDispatcher("/pages/user/updateAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        String id = req.getParameter("id");
        userService.updateAddress(new Address(address), Integer.parseInt(id));
        resp.sendRedirect("/");
    }
}
