package com.example.assignment.services.impl;

import com.example.assignment.models.Role;
import com.example.assignment.models.User;
import com.example.assignment.services.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static List<User> userList = new ArrayList<>();
    private static List<Role> roleList = new ArrayList<>();
    @Override
    public List<User> getAllUser() {
        if (userList.isEmpty()){
            userList.add(new User(
                    1,"yae","male","yae@gmmail.com",getRoleById(1)
            ));
            userList.add(new User(
                    2,"smey","male","smey@gmmail.com",getRoleById(2)
            ));
            userList.add(new User(
                    3,"wosuo","male","wosuo@gmmail.com",getRoleById(3)
            ));
            userList.add(new User(
                    4,"Nino","female","nino@gmmail.com",getRoleById(3)
            ));
        }
        return userList;
    }

    @Override
    public void insertUser(User user) {
        user.setId(userList.size()+1);
        userList.add(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserById(int id) {
        for (User user : userList){
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<Role> getAllRoles() {
        if (roleList.isEmpty()){
            Role roleAdmin = new Role(1,"admin");
            roleList.add(roleAdmin);
            Role roleUser = new Role(2,"user");
            roleList.add(roleUser);
            Role roleCashier = new Role(3,"Cashier");
            roleList.add(roleCashier);
            Role roleSuperAdmin = new Role(4,"Super admin");
            roleList.add(roleSuperAdmin);
        }
        return roleList;
    }

    @Override
    public Role getRoleById(int roleId) {
        for(Role role : roleList){
            if(role.getId()==roleId){
                return role;
            }
        }
        return null;
    }
}
