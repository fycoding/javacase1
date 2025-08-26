package top.fycoding.service.impl;

import java.util.List;
import java.util.Map;

import top.fycoding.dao.UserDao;
import top.fycoding.dao.impl.UserDaoImpl;
import top.fycoding.domain.UserModel;
import top.fycoding.service.UserService;

public class UserServiceImpl implements UserService{

    @Override
    public List<UserModel> findAll(Map<String, String> searchFields) {
        UserDao udao = new UserDaoImpl();
        return udao.findAll(searchFields);
    }

    @Override
    public int getTotal(Map<String, String> searchFields) {
        UserDao udao = new UserDaoImpl();
        searchFields.remove("page");
        return udao.getTotal(searchFields);
    }
    
}
