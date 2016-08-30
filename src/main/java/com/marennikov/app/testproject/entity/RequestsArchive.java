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
    @JoinColumn(name = "request_id", referencedColumnName = "request_id",  nullable = false)
    private Request request;

    @Column(name = "status",  nullable = false)
    private String status;

    @Column(name = "requester",  nullable = false)
    private Integer requester;

    @Column(name = "assignee",  nullable = false)
    private Integer assignee;

    @Column(name = "create_date",  nullable = false)
    private Date createDate;

    @Column(name = "processing_date")
    private Date processingDate;

    @Column(name = "version",  nullable = false)
    private Integer version;

    @Column(name = "ads_place_id",  nullable = false)
    private Integer adsPlaceId;

    @Column(name = "ads_construction_id",  nullable = false)
    private Integer adsConstructionId;

    @Column(name = "actual",  nullable = false)
    private Boolean actual;

    @Column(name = "rejected")
    private String rejected;


    public RequestsArchive() {
    }

    public RequestsArchive(
            Request request,
            String status,
            Integer requester,
            Integer assignee,
            Date createDate,
            Date processingDate,
            Integer version,
            Integer adsPlaceId,
            Integer adsConstructionId,
            Boolean actual,
            String rejected) {
        this.request = request;
        this.status = status;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adsPlaceId = adsPlaceId;
        this.adsConstructionId = adsConstructionId;
        this.actual = actual;
        this.rejected = rejected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

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
                ", request=" + request +
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
