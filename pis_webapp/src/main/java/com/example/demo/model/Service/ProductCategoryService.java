package com.example.demo.model.Service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductCategory;
import com.example.demo.model.Repository.ProductCategoryRepository;
import com.example.demo.model.Service.Interface.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findAll() {

        return (List<ProductCategory>) repository.findAll();

    }

}
