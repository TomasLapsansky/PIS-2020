package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.ProductCategory;
import com.vut.fit.pis2020.model.Repository.ProductCategoryRepository;
import com.vut.fit.pis2020.model.Service.Interface.IProductCategoryService;
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
