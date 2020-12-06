package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "day_start_borrow", columnDefinition = "DATE")
    private String dayStartBorrow;

    @Column(name = "day_end_borrow", columnDefinition = "DATE")
    private String dayEndBorrow;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "status", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private Set<BillDetail> billDetailSet;

    @Column(name = "code_borrow")
    private Integer codeBorrow;

    public Bill() {
    }

    public Bill(Integer id, String dayStartBorrow, String dayEndBorrow, Double totalMoney, Boolean status, Customer customer, Set<BillDetail> billDetailSet, Integer codeBorrow) {
        this.id = id;
        this.dayStartBorrow = dayStartBorrow;
        this.dayEndBorrow = dayEndBorrow;
        this.totalMoney = totalMoney;
        this.status = status;
        this.customer = customer;
        this.billDetailSet = billDetailSet;
        this.codeBorrow = codeBorrow;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayStartBorrow() {
        return dayStartBorrow;
    }

    public void setDayStartBorrow(String dayStartBorrow) {
        this.dayStartBorrow = dayStartBorrow;
    }

    public String getDayEndBorrow() {
        return dayEndBorrow;
    }

    public void setDayEndBorrow(String dayEndBorrow) {
        this.dayEndBorrow = dayEndBorrow;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<BillDetail> getBillDetailSet() {
        return billDetailSet;
    }

    public void setBillDetailSet(Set<BillDetail> billDetailSet) {
        this.billDetailSet = billDetailSet;
    }

    public Integer getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(Integer codeBorrow) {
        this.codeBorrow = codeBorrow;
    }
}
