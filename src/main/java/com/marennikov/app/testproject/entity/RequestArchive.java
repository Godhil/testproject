package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "request_archive")
public class RequestArchive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Request request;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User requester;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User assignee;

    @Column(nullable = false)
    private String createDate;

    @Column
    private String processingDate;

    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    private String adPlaceOwner;
    
    @Column(nullable = false)
    private String adPlaceAddress;
    
    @Column(nullable = false)
    private String adConstructionOwner;

    @Column(nullable = false)
    private String adConstructionNumber;

    @Column(nullable = false)
    private String adConstructionStatus;

    @Column(nullable = false)
    private String adConstructionType;

    @Column(nullable = false)
    private String status;

    @Column
    private String rejected;

    @Column
    private String activeStatus;

    public RequestArchive() {
    }

    public RequestArchive(
            Request request,
            User requester,
            User assignee,
            String createDate,
            String processingDate,
            Integer version,
            String adPlaceOwner,
            String adPlaceAddress,
            String adConstructionOwner,
            String adConstructionNumber,
            String adConstructionStatus,
            String adConstructionType,
            String status,
            String rejected,
            String activeStatus) {
        this.request = request;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlaceOwner = adPlaceOwner;
        this.adPlaceAddress = adPlaceAddress;
        this.adConstructionOwner = adConstructionOwner;
        this.adConstructionNumber = adConstructionNumber;
        this.adConstructionStatus = adConstructionStatus;
        this.adConstructionType = adConstructionType;
        this.status = status;
        this.rejected = rejected;
        this.activeStatus = activeStatus;
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

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
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

    public String getAdPlaceOwner() {
        return adPlaceOwner;
    }

    public void setAdPlaceOwner(String adPlaceOwner) {
        this.adPlaceOwner = adPlaceOwner;
    }

    public String getAdPlaceAddress() {
        return adPlaceAddress;
    }

    public void setAdPlaceAddress(String adPlaceAddress) {
        this.adPlaceAddress = adPlaceAddress;
    }

    public String getAdConstructionOwner() {
        return adConstructionOwner;
    }

    public void setAdConstructionOwner(String adConstructionOwner) {
        this.adConstructionOwner = adConstructionOwner;
    }

    public String getAdConstructionNumber() {
        return adConstructionNumber;
    }

    public void setAdConstructionNumber(String adConstructionNumber) {
        this.adConstructionNumber = adConstructionNumber;
    }

    public String getAdConstructionStatus() {
        return adConstructionStatus;
    }

    public void setAdConstructionStatus(String adConstructionStatus) {
        this.adConstructionStatus = adConstructionStatus;
    }

    public String getAdConstructionType() {
        return adConstructionType;
    }

    public void setAdConstructionType(String adConstructionType) {
        this.adConstructionType = adConstructionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "RequestArchive{" +
                "id=" + id +
                ", request=" + request +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate='" + createDate + '\'' +
                ", processingDate='" + processingDate + '\'' +
                ", version=" + version +
                ", adPlaceOwner='" + adPlaceOwner + '\'' +
                ", adPlaceAddress='" + adPlaceAddress + '\'' +
                ", adConstructionOwner='" + adConstructionOwner + '\'' +
                ", adConstructionNumber='" + adConstructionNumber + '\'' +
                ", adConstructionStatus='" + adConstructionStatus + '\'' +
                ", adConstructionType='" + adConstructionType + '\'' +
                ", status='" + status + '\'' +
                ", rejected='" + rejected + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}
