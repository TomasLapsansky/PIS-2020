package com.example.demo.model;

import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;
    private String password;
    private String name;
    private String surname;
    private String city;
    private String code;
    private String address;

    @ManyToOne
    @JoinColumn(name = "roleID")
    private Role role;

    public Integer getId() { return this.id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return this.email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return this.surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getCity() { return this.city; }
    public void setCity(String city) { this.city = city; }

    public String getCode() { return this.code; }
    public void setCode(String code) { this.code = code; }

    public String getAddress() { return this.address; }
    public void setAddress(String address) { this.address = address; }

}
