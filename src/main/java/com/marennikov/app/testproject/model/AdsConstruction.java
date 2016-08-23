package com.marennikov.app.testproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(name = "ads_place_id")
    private Integer adsPlaceId;

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

    public Integer getAdsPlaceId() {
        return adsPlaceId;
    }

    public void setAdsPlaceId(Integer adsPlaceId) {
        this.adsPlaceId = adsPlaceId;
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
