package service;


import pojo.User;

public interface UserService {
    User login(String username);

    int register(String username, String password);
}
