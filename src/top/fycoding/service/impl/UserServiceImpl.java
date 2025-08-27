package top.fycoding.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

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

    @Override
    public void add(Map<String, String[]> params) {
        UserDao udao = new UserDaoImpl();
        try {
            UserModel user = new UserModel();
            BeanUtils.populate(user, params);
            udao.add(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        UserDao udao = new UserDaoImpl();
        udao.delete(Integer.parseInt(id));
    }
    
}
