package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "appUser")
    private Customer customer;

    @OneToMany(mappedBy = "appUser")
    private Set<UserRole> userRoleSet;

    public AppUser() {
    }

    public AppUser(Integer id, String username, String password, Customer customer, Set<UserRole> userRoleSet) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.customer = customer;
        this.userRoleSet = userRoleSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
