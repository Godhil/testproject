package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads_place")
public class AdsPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ads_place_id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "owner")
    private String owner;

    @ManyToOne
    @JoinColumn(name = "municipality_id", referencedColumnName = "id")
    private Municipality municipality;

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
        return "AdsPlace{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", owner='" + owner + '\'' +
                ", municipality=" + municipality +
                '}';
    }
}
