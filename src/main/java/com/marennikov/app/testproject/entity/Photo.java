package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String path;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Request requests;

    public Photo() {
    }

    public Photo(String path, Request requests) {
        this.path = path;
        this.requests = requests;
    }

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

    public Request getRequests() {
        return requests;
    }

    public void setRequests(Request requests) {
        this.requests = requests;
    }


    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", requests=" + requests +
                '}';
    }


}
