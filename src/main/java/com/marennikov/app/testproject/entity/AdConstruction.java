package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "ad_construction")
public class AdConstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private AdPlace adPlace;

    @Column
    private String activeStatus;

    public AdConstruction() {
    }

    public AdConstruction(
            String owner,
            Integer number,
            String type,
            String status,
            String date,
            AdPlace adPlace,
            String activeStatus) {
        this.owner = owner;
        this.number = number;
        this.type = type;
        this.status = status;
        this.date = date;
        this.adPlace = adPlace;
        this.activeStatus = activeStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public AdPlace getAdPlace() {
        return adPlace;
    }

    public void setAdPlace(AdPlace adPlace) {
        this.adPlace = adPlace;
    }

    @Override
    public String toString() {
        return "AdConstruction{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                ", adPlace=" + adPlace +
                '}';
    }
}
