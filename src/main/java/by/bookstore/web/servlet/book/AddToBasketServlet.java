package by.bookstore.web.servlet.book;

import by.bookstore.entity.Basket;
import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import by.bookstore.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/addToBasket")
public class AddToBasketServlet extends HttpServlet {

    private BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book byId = bookService.findById(Integer.parseInt(id));
        Basket basket = (Basket) req.getSession().getAttribute("basket");
        basket.addBook(byId);
        resp.sendRedirect("/");
    }
}
