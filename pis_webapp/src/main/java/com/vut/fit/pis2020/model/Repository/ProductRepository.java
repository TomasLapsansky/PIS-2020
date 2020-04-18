package com.vut.fit.pis2020.model.Repository;

import com.vut.fit.pis2020.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
