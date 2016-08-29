package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "requests_archive")
public class RequestsArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "request_id", referencedColumnName = "request_id")
    private Requests requests;

    @Column(name = "status")
    private String status;

    @Column(name = "requester")
    private Integer requester;

    @Column(name = "assignee")
    private Integer assignee;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "processing_date")
    private Date processingDate;

    @Column(name = "version")
    private Integer version;

    @Column(name = "ads_place_id")
    private Integer adsPlaceId;

    @Column(name = "ads_construction_id")
    private Integer adsConstructionId;

    @Column(name = "actual")
    private Boolean actual;

    @Column(name = "rejected")
    private String rejected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Requests getRequests() {
        return requests;
    }

    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    //
//    public List<Requests> getRequestsId() {
//        return requestsId;
//    }
//
//    public void setRequestsId(List<Requests> requestsId) {
//        this.requestsId = requestsId;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRequester() {
        return requester;
    }

    public void setRequester(Integer requester) {
        this.requester = requester;
    }

    public Integer getAssignee() {
        return assignee;
    }

    public void setAssignee(Integer assignee) {
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

    public Integer getAdsPlaceId() {
        return adsPlaceId;
    }

    public void setAdsPlaceId(Integer adsPlaceId) {
        this.adsPlaceId = adsPlaceId;
    }

    public Integer getAdsConstructionId() {
        return adsConstructionId;
    }

    public void setAdsConstructionId(Integer adsConstructionId) {
        this.adsConstructionId = adsConstructionId;
    }

    public Boolean getActual() {
        return actual;
    }

    public void setActual(Boolean actual) {
        this.actual = actual;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    @Override
    public String toString() {
        return "RequestsArchive{" +
                "id=" + id +
                ", requests=" + requests +
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
