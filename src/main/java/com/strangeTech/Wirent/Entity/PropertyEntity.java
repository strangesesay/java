package com.strangeTech.Wirent.Entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Property")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int bedrooms;


    private  Float MonthlyRent;

    @ManyToOne
    @JoinColumn(name = "landlord_id")
    private LandlordEntity landlord;


    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<LeaseEntity> leases = new ArrayList<>();


    public PropertyEntity() {
    }


    //parameter constructor

    public PropertyEntity(Long id, String code, String address, int bedrooms, Float monthlyRent) {
        this.id = id;
        this.code = code;
        this.address = address;
        this.bedrooms = bedrooms;
        MonthlyRent = monthlyRent;
    }


    //getters and setters
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Float getMonthlyRent() {
        return MonthlyRent;
    }

    public void setMonthlyRent(Float monthlyRent) {
        MonthlyRent = monthlyRent;
    }

    public LandlordEntity getLandlord() {
        return landlord;
    }

    public void setLandlord(LandlordEntity landlord) {
        this.landlord = landlord;
    }

    public List<LeaseEntity> getLeases() {
        return leases;
    }

    public void setLeases(List<LeaseEntity> leases) {
        this.leases = leases;
    }
}
