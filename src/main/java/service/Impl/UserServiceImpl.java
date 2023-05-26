package service.Impl;

import dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    public String login(String username) {
        return userMapper.login(username);
    }

    @Override
    public int register(String username, String password) {
        return userMapper.register(username, password);
    }

}
