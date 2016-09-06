package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request_archive")
public class RequestArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Request request;

    @Column(nullable = false)
    private Integer requester;

    @Column(nullable = false)
    private Integer assignee;

    @Column(nullable = false)
    private String createDate;

    @Column
    private String processingDate;

    @Column(name = "version",  nullable = false)
    private Integer version;

    @Column(nullable = false)
    private Integer adPlaceId;

    @Column(nullable = false)
    private Integer adConstructionId;

    @Column(nullable = false)
    private Boolean actual;

    @Column
    private String rejected;


    public RequestArchive() {
    }

    public RequestArchive(
            Request request,
            String status,
            Integer requester,
            Integer assignee,
            String createDate,
            String processingDate,
            Integer version,
            Integer adPlaceId,
            Integer adsConstructionId,
            Boolean actual,
            String rejected) {
        this.request = request;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlaceId = adPlaceId;
        this.adConstructionId = adsConstructionId;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getAdPlaceId() {
        return adPlaceId;
    }

    public void setAdPlaceId(Integer adPlaceId) {
        this.adPlaceId = adPlaceId;
    }

    public Integer getAdConstructionId() {
        return adConstructionId;
    }

    public void setAdConstructionId(Integer adConstructionId) {
        this.adConstructionId = adConstructionId;
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
        return "RequestArchive{" +
                "id=" + id +
                ", request=" + request +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate=" + createDate +
                ", processingDate=" + processingDate +
                ", version=" + version +
                ", adPlaceId=" + adPlaceId +
                ", adConstructionId=" + adConstructionId +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                '}';
    }
}
