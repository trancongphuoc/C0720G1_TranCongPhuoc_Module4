package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateOfBirth", columnDefinition = "DATE")
    private String dateOfBirth;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "number_phone")
    private String numberPhone;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "member")
    private Set<BorrowBookCard> borrowBookCardSet;

    public Member() {
    }

    public Member(Integer id, String name, String dateOfBirth, Boolean gender, String numberPhone, String idCard, String email, String address, Set<BorrowBookCard> borrowBookCardSet) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberPhone = numberPhone;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<BorrowBookCard> getBorrowBookCardSet() {
        return borrowBookCardSet;
    }

    public void setBorrowBookCardSet(Set<BorrowBookCard> borrowBookCardSet) {
        this.borrowBookCardSet = borrowBookCardSet;
    }
}
