package com.vut.fit.pis2020.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "parentID")
    private Category parentCategory;

}
