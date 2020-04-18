package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.Repository.RoleRepository;
import com.vut.fit.pis2020.model.Role;
import com.vut.fit.pis2020.model.Service.Interface.IRoleService;
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
