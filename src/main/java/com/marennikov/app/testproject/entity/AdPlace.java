package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "ad_place")
public class AdPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Municipality municipality;

    @Column
    private String activeStatus;

    public AdPlace() {
    }

    public AdPlace(
            String address,
            String owner,
            Municipality municipality,
            String activeStatus) {
        this.address = address;
        this.owner = owner;
        this.municipality = municipality;
        this.activeStatus = activeStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "AdPlace{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", municipality=" + municipality +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}
