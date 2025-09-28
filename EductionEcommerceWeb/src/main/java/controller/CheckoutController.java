package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;
import model.Order;
import model.Order.OrderItem;
import dao.OrderDAO;

@WebServlet("/checkout")
public class CheckoutController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object u = req.getSession().getAttribute("user");
        if (u == null) { resp.sendRedirect("login"); return; }
        req.getRequestDispatcher("checkout.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession s = req.getSession();
        model.User user = (model.User) s.getAttribute("user");
        if (user == null) { resp.sendRedirect("login"); return; }

        List<model.Product> cart = (List<model.Product>) s.getAttribute("cart");
        if (cart == null || cart.isEmpty()) { resp.sendRedirect("products"); return; }

        String address = req.getParameter("address");
        double total = 0;
        List<OrderItem> items = new ArrayList<>();
        for (model.Product p : cart) {
            OrderItem it = new OrderItem();
            it.productId = p.getId();
            it.productName = p.getName();
            it.qty = 1;
            it.price = p.getPrice();
            total += p.getPrice();
            items.add(it);
        }

        OrderDAO od = new OrderDAO();
        int orderId = od.createOrder(user.getId(), total, address, items);
        if (orderId > 0) {
            s.setAttribute("orderId", orderId);
            s.removeAttribute("cart");
            resp.sendRedirect("payment");
        } else {
            req.setAttribute("error", "Could not place order. Try again.");
            req.getRequestDispatcher("checkout.jsp").forward(req, resp);
        }
    }
}
