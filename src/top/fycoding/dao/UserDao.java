package top.fycoding.dao;

import java.util.List;

import top.fycoding.domain.UserModel;

public interface UserDao {
    
    public boolean add(UserModel u);
    public boolean update(UserModel u);
    public boolean delete(int id);
    public UserModel findOne(int id);
    public List<UserModel> findAll();
    public int getTotal();
    
}
