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

@WebServlet(urlPatterns = "/order/findAllByStore")
public class FindAllOrdersByStoreServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Store[] all = storeService.getAll();
        req.setAttribute("stores", all);
        getServletContext().getRequestDispatcher("/pages/order/findAllByStore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storeId = req.getParameter("storeId");
        int i = Integer.parseInt(storeId);
        Store byId = storeService.getById(i);
        Order[] allByStore = orderService.findAllByStore(byId);
        req.setAttribute("orders", allByStore);
        getServletContext().getRequestDispatcher("/pages/order/findAllByStore.jsp").forward(req, resp);
    }
}
