package top.fycoding.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.fycoding.domain.UserModel;
import top.fycoding.service.UserService;
import top.fycoding.service.impl.UserServiceImpl;

@WebServlet("/list")
public class UserListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        UserService us = new UserServiceImpl();
        List<UserModel> list = us.findAll();
        req.setAttribute("list", list);

        // 转发给jsp
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
    
}
