package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dbEntityService implements IdbEntityService {

    @Autowired
    private dbEntityRepository repository;

    @Override
    public List<dbEntity> findAll() {
        var entities = (List<dbEntity>) repository.findAll();

        return entities;
    }
}
