package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import dao.ProductDAO;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        req.setAttribute("products", dao.findAll());
        req.getRequestDispatcher("products.jsp").forward(req, resp);
    }
}
