package com.example.assignment.services;

import com.example.assignment.models.Role;
import com.example.assignment.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void insertUser (User user);
    void updateUser (User user);
    User getUserById (int id);
    List<Role> getAllRoles();
    Role getRoleById(int roleId);
}
