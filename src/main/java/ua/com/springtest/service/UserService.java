package ua.com.springtest.service;

import ua.com.springtest.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(long id);
    User addUser(User user);
    void deleteUser(long id);
}
