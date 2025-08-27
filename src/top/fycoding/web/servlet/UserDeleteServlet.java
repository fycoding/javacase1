package top.fycoding.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.fycoding.service.UserService;
import top.fycoding.service.impl.UserServiceImpl;

@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id == null) {
            req.setAttribute("error_msg", "必须传入ID");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
        UserService us = new UserServiceImpl();
        us.delete(id);
        resp.sendRedirect(req.getContextPath() + "/list");
    }
    
}
