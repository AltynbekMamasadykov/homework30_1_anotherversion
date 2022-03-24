package com.company.service.impl;
import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.exceptions.ThatIdIsAlreadyInUse;
import com.company.model.User;
import com.company.service.UserService;
import java.util.List;


public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDao();

    @Override
    public void addUser(User user) {
        if(userDao.getUsers().stream().map(User::getId).toList().contains(user.getId())){
            try {
                throw new ThatIdIsAlreadyInUse("There is already a user with id:"+user.getId()+" So you cant add this user");
            }catch (ThatIdIsAlreadyInUse e) {
                System.out.println(e.getMessage());
            }
        }else {
            userDao.getUsers().add(user);
        }
    }

    @Override
    public User findById(int id) {
        User userToBeReturned = null;
        if(checkTrueOrFalse(id))
        try {
            throw new NoSuchIdException("There is no user with id: "+id);
        }catch (NoSuchIdException e) {
            System.out.println(e.getMessage());
        }
        for (User user:userDao.getUsers()) {
            if(user.getId()==id){
                userToBeReturned = user;
            }
        }
        return userToBeReturned;
    }

    @Override
    public void deleteWithId(int id) {
        if(checkTrueOrFalse(id))
            try {
                throw new NoSuchIdException("There is no user id "+id+" so you cannot delete it");
            }catch (NoSuchIdException e) {
                System.out.println(e.getMessage());
            }
        else{
            userDao.getUsers().removeIf(user -> user.getId() == id);
        }

    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    public boolean checkTrueOrFalse(int id) {
        return userDao.getUsers().stream().filter(user -> user.getId() == id).findFirst().isEmpty();
    }
}
