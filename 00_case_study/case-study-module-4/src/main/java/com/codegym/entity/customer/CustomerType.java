package com.codegym.entity.customer;


import com.codegym.entity.TypeCommon;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType extends TypeCommon {

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    Set<Customer> customerSet;

    public CustomerType() {
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
