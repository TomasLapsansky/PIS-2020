package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productcategory")
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;

}
