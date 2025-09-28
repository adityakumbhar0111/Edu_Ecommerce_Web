package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import model.Product;
import dao.ProductDAO;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession(true);
        List<Product> cart = (List<Product>) s.getAttribute("cart");
        if (cart == null) { cart = new ArrayList<>(); s.setAttribute("cart", cart); }

        String action = req.getParameter("action");
        String idStr = req.getParameter("id");
        if (action != null && idStr != null) {
            int id = Integer.parseInt(idStr);
            ProductDAO dao = new ProductDAO();
            if ("add".equalsIgnoreCase(action)) {
                Product p = dao.findById(id);
                if (p != null) cart.add(p);
            } else if ("remove".equalsIgnoreCase(action)) {
                cart.removeIf(p -> p.getId() == id);
            } else if ("clear".equalsIgnoreCase(action)) {
                cart.clear();
            }
            s.setAttribute("cart", cart);
        }
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { doGet(req, resp); }
}
