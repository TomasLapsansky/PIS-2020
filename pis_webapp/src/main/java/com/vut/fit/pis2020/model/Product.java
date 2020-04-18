package com.vut.fit.pis2020.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String specification;
    private String description;
    private Float price;
    private Boolean available;
    private Boolean checked;

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getSpecification() { return this.specification; }
    public void setSpecification(String specification) { this.specification = specification; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public Float getPrice() { return this.price; }
    public void setPrice(Float price) { this.price = price; }

    public Boolean getAvailable() { return this.available; }
    public void setAvailable(Boolean available) { this.available = available; }

    public Boolean getChecked() { return this.checked; }
    public void setChecked(Boolean checked) { this.checked = checked; }

}
