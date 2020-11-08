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

@WebServlet(urlPatterns = "/store/deleteByStore")
public class DeleteStoreByStoreServlet extends HttpServlet {

    private StoreService storeService = new StoreServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Store[] all = storeService.getAll();
        req.setAttribute("stores", all);
        getServletContext().getRequestDispatcher("/pages/store/deleteByStore.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int store = Integer.parseInt(req.getParameter("id"));
        Store byId = storeService.getById(store);
        storeService.delete(byId);
        resp.sendRedirect("/");
    }
}
