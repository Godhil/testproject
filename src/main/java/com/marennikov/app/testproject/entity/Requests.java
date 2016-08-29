package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests")
public class Requests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Integer id;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "requester", referencedColumnName = "user_id")
    private Users requester;

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "user_id")
    private Users assignee;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "processing_date")
    private Date processingDate;

    @Column(name = "version")
    private Integer version;

    @OneToOne
    @JoinColumn(name = "ads_place_id")
    private AdsPlace adsPlaceId;

    @OneToOne
    @JoinColumn(name = "ads_construction_id")
    private AdsConstruction adsConstructionId;

    @Column(name = "actual")
    private Boolean actual;

    @Column(name = "rejected")
    private String rejected;

    public Boolean getActual() {
        return actual;
    }

    public void setActual(Boolean actual) {
        this.actual = actual;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getRequester() {
        return requester;
    }

    public void setRequester(Users requester) {
        this.requester = requester;
    }

    public Users getAssignee() {
        return assignee;
    }

    public void setAssignee(Users assignee) {
        this.assignee = assignee;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public AdsPlace getAdsPlaceId() {
        return adsPlaceId;
    }

    public void setAdsPlaceId(AdsPlace adsPlaceId) {
        this.adsPlaceId = adsPlaceId;
    }

    public AdsConstruction getAdsConstructionId() {
        return adsConstructionId;
    }

    public void setAdsConstructionId(AdsConstruction adsConstructionId) {
        this.adsConstructionId = adsConstructionId;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }


    @Override
    public String toString() {
        return "Requests{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate=" + createDate +
                ", processingDate=" + processingDate +
                ", version=" + version +
                ", adsPlaceId=" + adsPlaceId +
                ", adsConstructionId=" + adsConstructionId +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                '}';
    }
}
