package com.vut.fit.pis2020.model.Service;

import com.vut.fit.pis2020.model.Product;
import com.vut.fit.pis2020.model.Repository.ProductRepository;
import com.vut.fit.pis2020.model.Service.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {

        return (List<Product>) repository.findAll();
    }

}
