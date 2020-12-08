package com.codegym.entity;

import com.codegym.anotation.CheckName;
import com.codegym.anotation.CheckNumber;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//    @CheckName
    @Column(name = "name")
    private String name;

//    @CheckNumber
    @Column(name = "rent_cost")
    private Double rentCost;

//    @CheckName
    @Column(name = "author")
    private String author;

    @Column(name = "amount")
    private Integer amount;

//    @NotBlank(message = "Do not be empty")
    @Column(name = "description")
    private String desctiption;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonBackReference
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetailSet;

    public Book() {
    }

    public Book(Integer id, String name, Double rentCost, String author, Integer amount, String desctiption, Category category, Set<BillDetail> billDetailSet) {
        this.id = id;
        this.name = name;
        this.rentCost = rentCost;
        this.author = author;
        this.amount = amount;
        this.desctiption = desctiption;
        this.category = category;
        this.billDetailSet = billDetailSet;
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

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String descripton) {
        this.desctiption = descripton;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<BillDetail> getBillDetailSet() {
        return billDetailSet;
    }

    public void setBillDetailSet(Set<BillDetail> billDetailSet) {
        this.billDetailSet = billDetailSet;
    }
}
