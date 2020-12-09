package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

//    @CheckName
    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

//    @PhoneNumber
    @Column(name = "number_phone")
    private String numberPhone;

//    @Email
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Bill> billSet;

    public Customer() {
    }

    public Customer(Integer id, String name, Boolean gender, String dateOfBirth, String address, String numberPhone, String email, AppUser appUser, Set<Bill> billSet) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
        this.appUser = appUser;
        this.billSet = billSet;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}
