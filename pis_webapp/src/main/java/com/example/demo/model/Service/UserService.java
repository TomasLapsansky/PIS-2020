package com.example.demo.model.Service;

import com.example.demo.model.Repository.UserRepository;
import com.example.demo.model.Service.Interface.IUserService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();

        return users;
    }

}
