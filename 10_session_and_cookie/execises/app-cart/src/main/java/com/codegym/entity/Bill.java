package com.codegym.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date_buy")
    private String dateBuy;

    @Column(name = "total_money")
    private Double totalMoney;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private Set<BillDetail> billDetail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Bill() {
    }

    public Bill(Integer id, String dateBuy, Double totalMoney, Set<BillDetail> billDetail, User user) {
        this.id = id;
        this.dateBuy = dateBuy;
        this.totalMoney = totalMoney;
        this.billDetail = billDetail;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Set<BillDetail> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(Set<BillDetail> billDetail) {
        this.billDetail = billDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
