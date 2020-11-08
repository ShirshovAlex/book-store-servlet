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

@WebServlet(urlPatterns = "/order/findById")
public class FindOrderByIdServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/order/findById.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        Order byId = orderService.findById(Integer.parseInt(orderId));
        req.setAttribute("orders", byId);
        getServletContext().getRequestDispatcher("/pages/order/findById.jsp").forward(req,resp);
    }
}
