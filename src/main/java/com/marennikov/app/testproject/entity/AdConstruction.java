package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ad_construction")
public class AdConstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ads_construction_id")
    private Integer id;

    @Column(name = "owner",  nullable = false)
    private String owner;

    @Column(name = "number",  nullable = false)
    private Integer number;

    @Column(name = "type",  nullable = false)
    private String type;

    @Column(name = "status",  nullable = false)
    private String status;

    @Column(name = "create_date",  nullable = false)
    private Date date;

    @OneToOne
    @JoinColumn(name = "ads_place_id",  nullable = false)
    private AdPlace adPlaceId;

    public AdConstruction() {
    }

    public AdConstruction(
            String owner,
            Integer number,
            String type,
            String status,
            Date date,
            AdPlace adPlaceId) {
        this.owner = owner;
        this.number = number;
        this.type = type;
        this.status = status;
        this.date = date;
        this.adPlaceId = adPlaceId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AdPlace getAdPlaceId() {
        return adPlaceId;
    }

    public void setAdPlaceId(AdPlace adPlaceId) {
        this.adPlaceId = adPlaceId;
    }

    @Override
    public String toString() {
        return "AdConstruction{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", adPlaceId=" + adPlaceId +
                '}';
    }
}
