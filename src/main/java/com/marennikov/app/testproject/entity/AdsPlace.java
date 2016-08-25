package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ads_place")
public class AdsPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "owner")
    private String owner;

    @OneToMany(mappedBy = "adsPlace")
    private List<Municipality> municipalityId;

    @OneToOne
    @JoinColumn(name = "ads_place_id")
    private AdsConstruction adsConstruction;

    @OneToOne
    @JoinColumn(name = "ads_place_id")
    private Requests requestAdsPlace;

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

    public List<Municipality> getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(List<Municipality> municipalityId) {
        this.municipalityId = municipalityId;
    }

    public AdsConstruction getAdsConstruction() {
        return adsConstruction;
    }

    public void setAdsConstruction(AdsConstruction adsConstruction) {
        this.adsConstruction = adsConstruction;
    }

    public Requests getRequestAdsPlace() {
        return requestAdsPlace;
    }

    public void setRequestAdsPlace(Requests requestAdsPlace) {
        this.requestAdsPlace = requestAdsPlace;
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
