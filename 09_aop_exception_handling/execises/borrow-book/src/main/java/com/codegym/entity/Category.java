package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Book> bookSet;

    public Category() {
    }

    public Category(Integer id, String name, Set<Book> bookSet) {
        this.id = id;
        this.name = name;
        this.bookSet = bookSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
