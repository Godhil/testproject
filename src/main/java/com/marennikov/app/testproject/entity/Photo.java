package com.marennikov.app.testproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "path")
    private String path;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,  mappedBy = "photo")
    private List<Requests> requestsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Requests> getRequestsId() {
        return requestsId;
    }

    public void setRequestsId(List<Requests> requestsId) {
        this.requestsId = requestsId;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", requestsId=" + requestsId +
                '}';
    }
}
