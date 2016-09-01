package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User requester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private User assignee;

    @Column(nullable = false)
    private Date createDate;

    @Column(nullable = false)
    private Date processingDate;

    @Column(nullable = false)
    private Integer version;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private AdPlace adPlaceId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private AdConstruction adConstruction;

    @Column(nullable = false)
    private Boolean actual;

    @Column
    private String rejected;

    public Request() {
    }

    public Request(
            String status,
            User requester,
            User assignee,
            Date createDate,
            Date processingDate,
            Integer version,
            AdPlace adPlaceId,
            AdConstruction adConstruction,
            Boolean actual,
            String rejected) {
        this.status = status;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlaceId = adPlaceId;
        this.adConstruction = adConstruction;
        this.actual = actual;
        this.rejected = rejected;
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

    public AdPlace getAdPlaceId() {
        return adPlaceId;
    }

    public void setAdPlaceId(AdPlace adPlaceId) {
        this.adPlaceId = adPlaceId;
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


    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", requester=" + requester +
                ", assignee=" + assignee +
                ", createDate=" + createDate +
                ", processingDate=" + processingDate +
                ", version=" + version +
                ", adPlaceId=" + adPlaceId +
                ", adConstruction=" + adConstruction +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                '}';
    }
}
