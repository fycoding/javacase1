package top.fycoding.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.fycoding.service.UserService;
import top.fycoding.service.impl.UserServiceImpl;

@WebServlet("/add")
public class UserAddServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        // 服务类
        UserService us = new UserServiceImpl();
        us.add(params);

        resp.sendRedirect(req.getContextPath() + "/list");
    }
    
}
