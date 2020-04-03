package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="role")
public class Role implements  Serializable {

    @Id
    private int id;

    private String name;

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

}
