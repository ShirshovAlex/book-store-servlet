package by.bookstore.web.servlet.order;

import by.bookstore.entity.Order;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/orders/findAllOrders")
public class FindAllOrdersServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order[] all = orderService.findAll();
        req.setAttribute("orders", all);
        getServletContext().getRequestDispatcher("/pages/order/findAllOrders.jsp").forward(req, resp);
    }
}
