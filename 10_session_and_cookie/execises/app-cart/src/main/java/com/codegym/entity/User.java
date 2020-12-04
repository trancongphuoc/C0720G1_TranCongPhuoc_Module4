package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "user")
public class User {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Bill> billSet;

    public User() {
    }



    public User(String username, String password, Set<Bill> billSet) {
        this.username = username;
        this.password = password;
        this.billSet = billSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Bill> getBillSet() {
        return billSet;
    }

    public void setBillSet(Set<Bill> billSet) {
        this.billSet = billSet;
    }
}

