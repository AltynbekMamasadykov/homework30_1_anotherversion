package com.company.service.impl;
import com.company.dao.UserDao;
import com.company.exceptions.NoSuchIdException;
import com.company.model.User;
import com.company.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        UserDao.users.add(user);
    }

    @Override
    public void findWithId(int id) {
        try{
            if(checkIfUserExist(id)){
                throw new NoSuchIdException("No user found with that id");
            }UserDao.users.stream().filter(user -> user.getId() == id).forEach(System.out::println);
        }catch (NoSuchIdException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteWithId(int id) {
        try{
            if(checkIfUserExist(id)){
                throw new NoSuchIdException("No user found with that id to delete");
            }UserDao.users.removeIf(user -> user.getId()==id);
        }catch (NoSuchIdException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return UserDao.users.stream().toList();
    }

    public boolean checkIfUserExist(int id) {
        return UserDao.users.stream().filter(user -> user.getId() == id).findFirst().isEmpty();
    }
}
