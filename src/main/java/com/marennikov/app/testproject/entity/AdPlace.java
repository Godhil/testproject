package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "ad_place")
public class AdPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ads_place_id")
    private Integer id;

    @Column(name = "address",  nullable = false)
    private String address;

    @Column(name = "owner",  nullable = false)
    private String owner;

    @ManyToOne
    @JoinColumn(name = "municipality_id",  nullable = false)
    private Municipality municipality;

    public AdPlace() {
    }

    public AdPlace(String address, String owner, Municipality municipality) {
        this.address = address;
        this.owner = owner;
        this.municipality = municipality;
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

    @Override
    public String toString() {
        return "AdPlace{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", municipality=" + municipality +
                '}';
    }
}
