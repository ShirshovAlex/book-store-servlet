package by.bookstore.web.servlet.order;

import by.bookstore.entity.Book;
import by.bookstore.entity.Order;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;
import by.bookstore.service.OrderService;
import by.bookstore.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/order/addBookByOrder")
public class AddBookByOrderServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order[] all = orderService.findAll();
        Book[] all1 = bookService.findAll();
        req.setAttribute("orders", all);
        req.setAttribute("books", all1);
        getServletContext().getRequestDispatcher("/pages/order/addBookByOrder.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String book = req.getParameter("bookId");
        String id = req.getParameter("orderId");
        Book byId = bookService.findById(Integer.parseInt(book));
        orderService.addBookById(byId, Integer.parseInt(id));
        resp.sendRedirect("/");
    }
}
