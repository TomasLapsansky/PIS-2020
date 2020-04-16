package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartitem")
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float amount;

    /* TODO access to referenced objects */
    @OneToOne
    @JoinColumn(name = "userID")
    private User user;

    @OneToOne
    @JoinColumn(name="productID")
    private Product product;

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public Float getAmount() { return this.amount; }
    public void setAmount(Float amount) { this.amount = amount; }


}
