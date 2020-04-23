package com.vut.fit.pis2020.persistance;

import com.vut.fit.pis2020.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    @Query( "SELECT c.id " +
            "FROM ProductCategory c " +
            "WHERE c.category = :categoryId " +
            "AND c.product = :productId")
    Long findProductCategoryConnection(
            @Param("productId") Long productId,
            @Param("categoryId") Long categoryId
    );
}
