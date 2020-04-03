package com.example.demo.model.Service;

import com.example.demo.model.Product;
import com.example.demo.model.Repository.ProductRepository;
import com.example.demo.model.Service.Interface.IProductService;
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
