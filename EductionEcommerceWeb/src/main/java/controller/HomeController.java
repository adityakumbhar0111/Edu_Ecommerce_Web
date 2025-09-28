package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import dao.ProductDAO;

@WebServlet({"/", "/home"})
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAO dao = new ProductDAO();
        req.setAttribute("featured", dao.findAll());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
