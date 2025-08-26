package top.fycoding.dao;

import java.util.List;
import java.util.Map;

import top.fycoding.domain.UserModel;

public interface UserDao {
    
    public boolean add(UserModel u);
    public boolean update(UserModel u);
    public boolean delete(int id);
    public UserModel findOne(int id);
    public List<UserModel> findAll(Map<String, String> searchFields);
    public int getTotal(Map<String, String> searchFields);
    
}
