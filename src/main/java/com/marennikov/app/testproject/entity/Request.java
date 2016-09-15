package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
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

    @Column
    private Boolean actual;

    @Column
    private String rejected;

    @Column
    private String activeStatus;

    public Request() {
    }

    public Request(
            String status,
            User requester,
            User assignee,
            String createDate,
            String processingDate,
            Integer version,
            AdPlace adPlace,
            AdConstruction adConstruction,
            Boolean actual,
            String rejected,
            String activeStatus) {
        this.status = status;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlace = adPlace;
        this.adConstruction = adConstruction;
        this.actual = actual;
        this.rejected = rejected;
        this.activeStatus = activeStatus;
    }

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

    public void setAdConstruction(AdConstruction adConstruction) {
        this.adConstruction = adConstruction;
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
        return "Request{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate='" + createDate + '\'' +
                ", processingDate='" + processingDate + '\'' +
                ", version=" + version +
                ", adPlace=" + adPlace +
                ", adConstruction=" + adConstruction +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }
}
