package com.vut.fit.pis2020.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Email(message = "Provide a valid email")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 255)
    @Column(name = "surname")
    private String surName;

    @Null
    @Size(max = 255)
    @Column(name = "city")
    private String city;

    @Null
    @Size(max = 15)
    @Column(name = "code")
    private String code;

    @Null
    @Size(max = 255)
    @Column(name = "address")
    private String address;

    // TODO role @OneToMany
    @Column(name = "role_id")
    private Long roleId;
}
