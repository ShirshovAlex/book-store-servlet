package by.bookstore.web.servlet.store;

import by.bookstore.entity.Address;
import by.bookstore.entity.Store;
import by.bookstore.service.StoreService;
import by.bookstore.service.StoreServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/store/save")
public class SaveStoreServlet extends HttpServlet {

    private StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/store/saveStore.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String street = req.getParameter("street");
        storeService.save(new Store(name, new Address(street)));
        resp.sendRedirect("/");
    }
}
