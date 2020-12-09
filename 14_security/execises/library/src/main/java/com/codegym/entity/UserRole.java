package com.codegym.entity;


import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;


    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private AppRole appRole;


    public UserRole() {
    }

    public UserRole(Integer id, AppUser appUser, AppRole appRole) {
        this.id = id;
        this.appUser = appUser;
        this.appRole = appRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}
