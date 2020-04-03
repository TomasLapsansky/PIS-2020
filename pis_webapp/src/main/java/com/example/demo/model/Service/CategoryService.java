package com.example.demo.model.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Repository.CategoryRepository;
import com.example.demo.model.Service.Interface.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {

        return (List<Category>) repository.findAll();

    }
}
