package by.bookstore.web.servlet.user;

import by.bookstore.entity.Order;
import by.bookstore.entity.User;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;
import by.bookstore.service.UserService;
import by.bookstore.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AccountServlet", urlPatterns = "/user/account")
public class AccountServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Order[] allByUser = orderService.findAllByUser(user);
        req.setAttribute("orders", allByUser);
        getServletContext().getRequestDispatcher("/pages/user/account.jsp").forward(req, resp);
    }

}
