package by.bookstore.web.servlet.order;

import by.bookstore.entity.Book;
import by.bookstore.entity.Order;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/order/findBookByOrder")
public class FindBookByOrderServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order[] all = orderService.findAll();
        req.setAttribute("orders", all);
        getServletContext().getRequestDispatcher("/pages/order/findBookByOrder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        Book[] allBooksById = orderService.findAllBooksById(Integer.parseInt(orderId));
        req.setAttribute("books",allBooksById);
        getServletContext().getRequestDispatcher("/pages/order/findBookByOrder.jsp").forward(req, resp);
    }
}
