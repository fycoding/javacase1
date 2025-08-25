package top.fycoding.service;

import java.util.List;

import top.fycoding.domain.UserModel;

public interface UserService {

    List<UserModel> findAll();
    
}
