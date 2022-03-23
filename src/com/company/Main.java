package com.company;

import com.company.enums.Gender;
import com.company.model.User;
import com.company.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"aza",13, Gender.MALE);
        User user2 = new User(2,"ali",15, Gender.MALE);
        User user3 = new User(3,"adi",20, Gender.FEMALE);

        UserServiceImpl userService = new UserServiceImpl();
        userService.addUser(user1);
        userService.findWithId(6);
        System.out.println(userService.getAllUsers());
        userService.addUser(user2);
        userService.addUser(user3);
        System.out.println(userService.getAllUsers());
        userService.deleteWithId(2);
        userService.deleteWithId(7);
        System.out.println(userService.getAllUsers());

    }
}
