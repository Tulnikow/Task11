package ru.tiulnikow.springboot1.services;
import ru.tiulnikow.springboot1.model.User;

import java.util.List;

public interface UserService {
     void addUser(User user);

     void updateUser(int id,User user);

     void removeUser(int id);

     User getUserById(int id);

     List<User> listUser();
}
