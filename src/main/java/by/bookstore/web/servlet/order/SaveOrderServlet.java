package by.bookstore.web.servlet.order;

import by.bookstore.entity.*;
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

@WebServlet(urlPatterns = "/order/save")
public class SaveOrderServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();
    private StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Store[] all = storeService.getAll();
        req.setAttribute("stores", all);
        getServletContext().getRequestDispatcher("/pages/order/saveOrder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isDelivery = Boolean.parseBoolean(req.getParameter("isDelivery"));
        User user = (User) req.getSession().getAttribute("user");
        Basket basket = (Basket) req.getSession().getAttribute("basket");
        if (isDelivery) {
            String street = req.getParameter("address");
            if (street.isEmpty()) {
                req.setAttribute("message", "Address must be not null");
                getServletContext().getRequestDispatcher("/pages/order/saveOrder.jsp").forward(req, resp);
            } else {
                orderService.save(new Order(new Address(street), basket.getBooks(), user));
               req.getSession().setAttribute("basket", new Basket(new Book[10]));
                resp.sendRedirect("/");
            }
        } else {
            String storeId = req.getParameter("storeId");
            int i = Integer.parseInt(storeId);
            Store byId = storeService.getById(i);
            orderService.save(new Order(byId, basket.getBooks(), user));
            req.getSession().setAttribute("basket", new Basket(new Book[10]));
            resp.sendRedirect("/");
        }
    }
}
