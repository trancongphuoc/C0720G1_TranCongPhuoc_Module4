package com.codegym.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class AppRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "appRole")
    private Set<UserRole> userRoleSet;

    public AppRole() {
    }

    public AppRole(Integer id, String name, Set<UserRole> userRoleSet) {
        this.id = id;
        this.name = name;
        this.userRoleSet = userRoleSet;
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

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
