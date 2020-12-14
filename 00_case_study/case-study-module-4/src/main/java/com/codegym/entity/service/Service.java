package com.codegym.entity.service;

import com.codegym.entity.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "area", columnDefinition = "DOUBLE", nullable = false)
    private String area;

    @Column(name = "cost", columnDefinition = "DOUBLE", nullable = false)
    private String cost;

    @Column(name = "max_people", columnDefinition = "INT")
    private String maxPeople;

    @Column(name = "standard_room")
    private String standardRoom;

    @Column(name = "description")
    private String description;

    @Column(name = "status", columnDefinition = "BIT DEFAULT 0")
    private String status;
    @Column(name = "pool_area", columnDefinition = "DOUBLE")
    private String poolArea;

    @Column(name = "number_of_floor", columnDefinition = "INT")
    private String numberOfFloor;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    public Service() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
