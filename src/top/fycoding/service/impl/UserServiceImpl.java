package top.fycoding.service.impl;

import java.util.List;

import top.fycoding.dao.UserDao;
import top.fycoding.dao.impl.UserDaoImpl;
import top.fycoding.domain.UserModel;
import top.fycoding.service.UserService;

public class UserServiceImpl implements UserService{

    @Override
    public List<UserModel> findAll() {
        UserDao udao = new UserDaoImpl();
        return udao.findAll();
    }
    
}
