package com.company.service;
import com.company.model.User;
import java.util.List;

public interface UserService {

    void addUser(User user);
    User findById(int id);
    void deleteWithId(int id);
    List<User> getAllUsers();

}
