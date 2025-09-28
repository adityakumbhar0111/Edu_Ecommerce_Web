package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import dao.UserDAO;
import model.User;

@WebServlet({"/login","/logout","/register"})
public class AuthController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getServletPath();
        if ("/logout".equals(p)) {
            req.getSession().invalidate();
            resp.sendRedirect("home");
            return;
        }
        if ("/register".equals(p)) req.getRequestDispatcher("register.jsp").forward(req, resp);
        else req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p = req.getServletPath();
        UserDAO dao = new UserDAO();
        if ("/register".equals(p)) {
            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            String fullname = req.getParameter("fullname");
            if (dao.findByEmail(email) != null) {
                req.setAttribute("error", "Email already used");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            User u = dao.create(email, pass, fullname);
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("home");
        } else { // login
            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            User u = dao.findByEmail(email);
            if (u == null || !dao.checkPassword(u, pass)) {
                req.setAttribute("error", "Invalid credentials");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }
            req.getSession().setAttribute("user", u);
            resp.sendRedirect("home");
        }
    }
}
