package by.bookstore.web.servlet.order;

import by.bookstore.entity.Address;
import by.bookstore.entity.Order;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/orders/findByAddress")
public class FindAllByAddress extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/order/findAllByAddress.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = req.getParameter("address");
        Order[] allByAddress = orderService.findAllByAddress(new Address(address));
        req.setAttribute("orders",allByAddress);
        getServletContext().getRequestDispatcher("/pages/order/findAllByAddress.jsp").forward(req, resp);
    }
}
