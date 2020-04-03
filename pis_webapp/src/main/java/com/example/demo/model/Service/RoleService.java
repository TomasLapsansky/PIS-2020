package com.example.demo.model.Service;

import com.example.demo.model.Repository.RoleRepository;
import com.example.demo.model.Role;
import com.example.demo.model.Service.Interface.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> findAll() {

        return (List<Role>) repository.findAll();
    }

}
