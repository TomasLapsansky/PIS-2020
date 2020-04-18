package com.vut.fit.pis2020.model.Repository;


import com.vut.fit.pis2020.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
}
