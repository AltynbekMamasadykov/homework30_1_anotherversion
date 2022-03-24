package com.company;
import com.company.enums.Gender;
import com.company.model.User;
import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;

public class Main {

    public static void main(String[] args) {

        // ----------------- creating users -----------------

        User user1 = new User(1,"aza",13, Gender.MALE);
        User user2 = new User(2,"ali",15, Gender.MALE);
        User user3 = new User(3,"adi",20, Gender.FEMALE);
        User user4 = new User(1,"asi",15, Gender.FEMALE); // id 1 is already in use

        UserService userService = new UserServiceImpl();

        //-----------  adding users and getting all users -----------

        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        userService.addUser(user4); //checks and throws ThatIdIsAlreadyInUse Exception
        System.out.println();
        userService.getAllUsers().forEach(System.out::println);
        System.out.println();

        //------------  getting user by id ---------------

        System.out.println(userService.findById(1));
        System.out.println(userService.findById(7)); // checks and throws NoSuchId Exception returns null
        System.out.println();

        //-------------- deleting user by id -----------------

        userService.deleteWithId(2);
        userService.deleteWithId(22); //checks and throws NoSuchId Exception
        userService.getAllUsers().forEach(System.out::println);

    }
}
