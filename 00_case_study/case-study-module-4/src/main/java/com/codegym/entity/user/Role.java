package com.codegym.entity.user;

import com.codegym.entity.TypeCommon;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends TypeCommon {

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoleSet;

    public Role() {
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
