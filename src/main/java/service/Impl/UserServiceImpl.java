package service.Impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    public User login(String username) {
        return userMapper.login(username);
    }

    @Override
    public int register(String username, String password) {
        return userMapper.register(username, password);
    }

}
