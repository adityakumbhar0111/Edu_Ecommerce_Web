package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // show payment page (simulate)
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // simulate success
        req.setAttribute("message", "Payment successful. Thank you!");
        req.getRequestDispatcher("payment.jsp").forward(req, resp);
    }
}
