package com.strangeTech.Wirent.Entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Lease")
public class LeaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String LeaseNumber;


    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private TenantEntity tenant;


    @ManyToOne
    @JoinColumn(name = "property_id")
    private PropertyEntity property;

    private LocalDate startDate;

    //store monthly rent for this lease
    private BigDecimal agreedRent;


    public LeaseEntity() {
    }

    public LeaseEntity(Long id, String leaseNumber, LocalDate startDate, BigDecimal agreedRent) {
        this.id = id;
        LeaseNumber = leaseNumber;
        this.startDate = startDate;
        this.agreedRent = agreedRent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaseNumber() {
        return LeaseNumber;
    }

    public void setLeaseNumber(String leaseNumber) {
        LeaseNumber = leaseNumber;
    }

    public TenantEntity getTenant() {
        return tenant;
    }

    public void setTenant(TenantEntity tenant) {
        this.tenant = tenant;
    }

    public PropertyEntity getProperty() {
        return property;
    }

    public void setProperty(PropertyEntity property) {
        this.property = property;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getAgreedRent() {
        return agreedRent;
    }

    public void setAgreedRent(BigDecimal agreedRent) {
        this.agreedRent = agreedRent;
    }
}
