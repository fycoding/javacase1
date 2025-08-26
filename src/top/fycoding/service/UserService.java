package top.fycoding.service;

import java.util.List;
import java.util.Map;

import top.fycoding.domain.UserModel;

public interface UserService {

    List<UserModel> findAll(Map<String, String> searchFields);

    int getTotal(Map<String, String> searchFields);
    
}
