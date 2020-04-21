package com.vut.fit.pis2020.persistance;

import com.vut.fit.pis2020.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
