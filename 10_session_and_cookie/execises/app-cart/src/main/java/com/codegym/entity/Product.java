package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private Integer amount;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetailSet;

    public Product() {
    }

    public Product(Integer id, String name, String description, Double price, Integer amount, Set<BillDetail> billDetailSet) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<BillDetail> getBillDetailSet() {
        return billDetailSet;
    }

    public void setBillDetailSet(Set<BillDetail> billDetailSet) {
        this.billDetailSet = billDetailSet;
    }
}
