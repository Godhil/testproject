package com.marennikov.app.testproject.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests")
public class Requests {

    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "requestRequester")
    private Users requester;

    @OneToMany(mappedBy = "requestAssignee")
    private Users assignee;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "progressing_date")
    private Date progressingDate;

    @Column(name = "version")
    private Integer version;

    @OneToOne(mappedBy = "requestAdsPlace")
    private AdsPlace adsPlaceId;

    @OneToOne(mappedBy = "requestAdsConstruction")
    private AdsConstruction adsConstructionId;

    @Column(name = "actual")
    private Boolean actual;

    @Column(name = "rejected")
    private String rejected;

    @ManyToOne
    @JoinColumn(name = "requests_id")
    private Photo photo;

    @ManyToOne
    @JoinColumn(name = "requests_id")
    private RequestsArchive requestsArchive;

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

    public Date getProgressingDate() {
        return progressingDate;
    }

    public void setProgressingDate(Date progressingDate) {
        this.progressingDate = progressingDate;
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

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public RequestsArchive getRequestsArchive() {
        return requestsArchive;
    }

    public void setRequestsArchive(RequestsArchive requestsArchive) {
        this.requestsArchive = requestsArchive;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate=" + createDate +
                ", progressingDate=" + progressingDate +
                ", version=" + version +
                ", adsPlaceId=" + adsPlaceId +
                ", adsConstructionId=" + adsConstructionId +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                '}';
    }
}
