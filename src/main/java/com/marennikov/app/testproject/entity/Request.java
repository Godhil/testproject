package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Integer id;

    @Column(name = "status",  nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "requester", referencedColumnName = "user_id")
    private User requester;

    @ManyToOne
    @JoinColumn(name = "assignee", referencedColumnName = "user_id")
    private User assignee;

    @Column(name = "create_date",  nullable = false)
    private Date createDate;

    @Column(name = "processing_date",  nullable = false)
    private Date processingDate;

    @Column(name = "version",  nullable = false)
    private Integer version;

    @OneToOne
    @JoinColumn(name = "ads_place_id",  nullable = false)
    private AdPlace adPlaceId;

    @OneToOne
    @JoinColumn(name = "ads_construction_id",  nullable = false)
    private AdConstruction adConstructionId;

    @Column(name = "actual",  nullable = false)
    private Boolean actual;

    @Column(name = "rejected")
    private String rejected;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photo;

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
            AdConstruction adConstructionId,
            Boolean actual,
            String rejected,
            Photo photo) {
        this.status = status;
        this.requester = requester;
        this.assignee = assignee;
        this.createDate = createDate;
        this.processingDate = processingDate;
        this.version = version;
        this.adPlaceId = adPlaceId;
        this.adConstructionId = adConstructionId;
        this.actual = actual;
        this.rejected = rejected;
        this.photo = photo;
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

    public AdConstruction getAdConstructionId() {
        return adConstructionId;
    }

    public void setAdConstructionId(AdConstruction adConstructionId) {
        this.adConstructionId = adConstructionId;
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
                ", adConstructionId=" + adConstructionId +
                ", actual=" + actual +
                ", rejected='" + rejected + '\'' +
                '}';
    }
}
