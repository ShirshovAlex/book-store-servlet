package by.bookstore.web.servlet.store;

import by.bookstore.entity.Store;
import by.bookstore.service.StoreService;
import by.bookstore.service.StoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/store/getAll")
public class GetAllStoresServlet extends HttpServlet {

    private StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Store[] all = storeService.getAll();
        req.setAttribute("all",all);
        getServletContext().getRequestDispatcher("/pages/store/getAll.jsp").forward(req,resp);
    }
}
