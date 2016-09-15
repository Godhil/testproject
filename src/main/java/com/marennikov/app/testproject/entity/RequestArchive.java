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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private AdPlace adPlace;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private AdConstruction adConstruction;

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
            AdPlace adPlace,
            AdConstruction adConstruction,
            String status,
            String rejected,
            String activeStatus) {
        this.request = request;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlace = adPlace;
        this.adConstruction = adConstruction;
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

    public AdPlace getAdPlace() {
        return adPlace;
    }

    public void setAdPlace(AdPlace adPlace) {
        this.adPlace = adPlace;
    }

    public AdConstruction getAdConstruction() {
        return adConstruction;
    }

    public void setAdConstructionId(AdConstruction adConstruction) {
        this.adConstruction = adConstruction;
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
                ", adPlace=" + adPlace +
                ", adConstruction=" + adConstruction +
                ", status=" + status +
                ", rejected='" + rejected + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}
