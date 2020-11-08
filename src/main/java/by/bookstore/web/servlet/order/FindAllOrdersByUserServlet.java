package by.bookstore.web.servlet.order;

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

@WebServlet(urlPatterns = "/order/findAllByUser")
public class FindAllOrdersByUserServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User[] all = userService.findAll();
        req.setAttribute("users", all);
        getServletContext().getRequestDispatcher("/pages/order/findAllByUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        User byId = userService.findById(Integer.parseInt(userId));
        Order[] allByUser = orderService.findAllByUser(byId);
        req.setAttribute("orders",allByUser);
        getServletContext().getRequestDispatcher("/pages/order/findAllByUser.jsp").forward(req, resp);
    }
}
