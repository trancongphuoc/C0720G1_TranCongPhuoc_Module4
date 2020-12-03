package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private Set<BorrowBookCard> borrowBookCardSet;

    public Book() {
    }

    public Book(Integer id, String name, String author, String description, Integer amount, Category category, Set<BorrowBookCard> borrowBookCardSet) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.borrowBookCardSet = borrowBookCardSet;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<BorrowBookCard> getBorrowBookCardSet() {
        return borrowBookCardSet;
    }

    public void setBorrowBookCardSet(Set<BorrowBookCard> borrowBookCardSet) {
        this.borrowBookCardSet = borrowBookCardSet;
    }
}
