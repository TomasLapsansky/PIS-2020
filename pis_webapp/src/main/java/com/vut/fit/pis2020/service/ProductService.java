package com.vut.fit.pis2020.service;

import com.vut.fit.pis2020.entity.Product;
import com.vut.fit.pis2020.entity.ProductPhoto;
import com.vut.fit.pis2020.persistance.ProductPhotoRepository;
import com.vut.fit.pis2020.persistance.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    public Product findById(Long id) {
        return productRepository.getOne(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    /* Photos */

    public List<ProductPhoto> findPhotosByProduct(Long id) {
        Product product = productRepository.getOne(id);

        return productPhotoRepository.findByProduct(product);
    }

    public ProductPhoto findPhotoById(Long id) {
        return productPhotoRepository.getOne(id);
    }

    public ProductPhoto savePhoto(ProductPhoto productPhoto) {
        return productPhotoRepository.save(productPhoto);
    }

    public void deletePhoto(ProductPhoto productPhoto) {
        productPhotoRepository.delete(productPhoto);
    }
}
