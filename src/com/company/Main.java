package com.company;

import com.company.enums.Gender;
import com.company.model.User;
import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"aza",13, Gender.MALE);
        User user2 = new User(2,"ali",15, Gender.MALE);
        User user3 = new User(3,"adi",20, Gender.FEMALE);

        List<User> newList = new ArrayList<>();
        newList.add(user1); newList.add(user2); newList.add(user3);

        UserService userService = new UserServiceImpl();
        userService.addUser(newList);

        System.out.println(userService.findById(1));
        System.out.println(userService.findById(7));
        System.out.println();

        userService.getAllUsers().forEach(System.out::println);
        System.out.println();

        userService.deleteWithId(2);
        userService.getAllUsers().forEach(System.out::println);

    }
}
