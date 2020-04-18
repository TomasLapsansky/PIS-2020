package com.vut.fit.pis2020.model.Service.Interface;

import com.vut.fit.pis2020.model.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    List<ProductCategory> findAll();
}
