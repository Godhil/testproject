package com.marennikov.app.testproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ads_construction")
public class AdsConstruction {

    @Column(name = "id")
    private Integer id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "number")
    private Integer number;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "create_date")
    private Date date;

    @OneToOne(mappedBy = "adsConstruction")
    private AdsPlace adsPlaceId;

    @OneToOne
    @JoinColumn(name = "ads_construction_id")
    private Requests requestAdsConstruction;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AdsPlace getAdsPlaceId() {
        return adsPlaceId;
    }

    public void setAdsPlaceId(AdsPlace adsPlaceId) {
        this.adsPlaceId = adsPlaceId;
    }

    public Requests getRequestAdsConstruction() {
        return requestAdsConstruction;
    }

    public void setRequestAdsConstruction(Requests requestAdsConstruction) {
        this.requestAdsConstruction = requestAdsConstruction;
    }

    @Override
    public String toString() {
        return "AdsConstruction{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", adsPlaceId=" + adsPlaceId +
                '}';
    }
}
