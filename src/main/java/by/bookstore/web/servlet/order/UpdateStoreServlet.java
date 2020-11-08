package by.bookstore.web.servlet.order;

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

@WebServlet(urlPatterns = "/order/updateStore")
public class UpdateStoreServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order[] all = orderService.findAll();
        req.setAttribute("orders", all);
        Store[] all1 = storeService.getAll();
        req.setAttribute("stores", all1);
        getServletContext().getRequestDispatcher("/pages/order/updateStore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String storeId = req.getParameter("storeId");
        Store byId = storeService.getById(Integer.parseInt(storeId));
        orderService.updateStore(byId, Integer.parseInt(orderId));
        resp.sendRedirect("/");
    }
}
