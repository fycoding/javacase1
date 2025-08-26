package top.fycoding.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.fycoding.domain.Page;
import top.fycoding.domain.UserModel;
import top.fycoding.service.UserService;
import top.fycoding.service.impl.UserServiceImpl;

@WebServlet("/list")
public class UserListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> params = req.getParameterMap();

        // 服务类
        UserService us = new UserServiceImpl();

        // 搜索项
        Map<String, String> searchFields = new HashMap<String, String>(); 
        params.forEach((key, value) -> {
            searchFields.put(key, value[0]);
        });

        // 页码设置
        Page page = new Page(us.getTotal(searchFields));
        String curPage = req.getParameter("page");
        page.setPage(Integer.parseInt(curPage));

        // 查询数据
        List<UserModel> list = us.findAll(searchFields);

        req.setAttribute("list", list);
        req.setAttribute("page", page);
        req.setAttribute("search", searchFields);

        // 转发给jsp
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
    
}
