package service;


import pojo.User;
public interface UserService {
    String login(String username);

    int register(String username, String password);
}
