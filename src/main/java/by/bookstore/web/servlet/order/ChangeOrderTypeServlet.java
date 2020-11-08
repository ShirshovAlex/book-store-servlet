package by.bookstore.web.servlet.order;

import by.bookstore.entity.Address;
import by.bookstore.entity.Order;
import by.bookstore.entity.Store;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;
import by.bookstore.service.StoreService;
import by.bookstore.service.StoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/order/changeOrderType")
public class ChangeOrderTypeServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order[] all = orderService.findAll();
        req.setAttribute("orders", all);
        Store[] all1 = storeService.getAll();
        req.setAttribute("stores", all1);
        getServletContext().getRequestDispatcher("/pages/order/changeOrderType.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        int i = Integer.parseInt(orderId);
        String isDelivery = req.getParameter("isDelivery");
        boolean b = Boolean.parseBoolean(isDelivery);
        String street = req.getParameter("street");
        String store = req.getParameter("storeId");
        Store byId = storeService.getById(Integer.parseInt(store));
        if (b) {
            orderService.updateOrderType(i, null, new Address(street), true);
            resp.sendRedirect("/");
        } else {
            orderService.updateOrderType(i, byId, null, false);
            resp.sendRedirect("/");
        }
    }
}
