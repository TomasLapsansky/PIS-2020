package com.example.demo;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="test")
public class dbEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String text;

    public dbEntity() {
    }

    public dbEntity(Long id, String text) {

        this.id = id;
        this.text = text;
    }

    public Long getID() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
