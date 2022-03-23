package com.company.service.impl;
import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    @Override
    public void addUser(List<User> user) {
        userDao.setUsers(user);
    }

    @Override
    public List<User> findById(int id) {
        if (checkTrueOrFalse(id)) {
            try {
                throw new NoSuchIdException("There is no such id");
            }catch (NoSuchIdException e) {
                System.out.println(e.getMessage());
            }
        }
        return userDao.getUsers().stream().filter(x -> x.getId() == id).toList();
    }

    @Override
    public void deleteWithId(int id) {
        userDao.getUsers().removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers().stream().toList();
    }

    public boolean checkTrueOrFalse(int id) {
        return userDao.getUsers().stream().filter(user -> user.getId() == id).findFirst().isEmpty();
    }
}
