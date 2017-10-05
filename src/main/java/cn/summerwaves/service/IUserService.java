package cn.summerwaves.service;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Service;


public interface IUserService {
    void insertUser(User user);

    User selectUserByName(String username);
}
