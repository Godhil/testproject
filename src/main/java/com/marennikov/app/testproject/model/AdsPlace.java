package com.marennikov.app.testproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ads_place")
public class AdsPlace {

    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "owner")
    private String owner;

    @Column(name = "municipality_id")
    private Integer municipalityId;

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

    public Integer getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(Integer municipalityId) {
        this.municipalityId = municipalityId;
    }

    @Override
    public String toString() {
        return "AdsPlace{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", municipalityId=" + municipalityId +
                '}';
    }
}
