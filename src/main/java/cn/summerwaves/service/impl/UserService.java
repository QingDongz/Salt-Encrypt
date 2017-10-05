package cn.summerwaves.service.impl;

import cn.summerwaves.dao.UserDao;
import cn.summerwaves.model.User;
import cn.summerwaves.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {
    @Resource
    private UserDao dao;

    @Override
    public void insertUser(User user) {
        dao.insertUser(user);
    }

    @Override
    public User selectUserByName(String username) {
        return dao.selectUserByName(username);
    }


}
