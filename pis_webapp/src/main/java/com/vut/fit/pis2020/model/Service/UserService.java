package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.Repository.UserRepository;
import com.vut.fit.pis2020.model.Service.Interface.IUserService;
import com.vut.fit.pis2020.model.User;
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
