package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.Category;
import com.vut.fit.pis2020.model.Repository.CategoryRepository;
import com.vut.fit.pis2020.model.Service.Interface.ICategoryService;
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
