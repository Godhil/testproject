package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "photo_id")
    private Integer id;

    @Column(name = "path",  nullable = false)
    private String path;

    @OneToMany(mappedBy = "photo")
//    @JoinColumn(name = "request_id",  nullable = false)
    private List<Request> requests;

    public Photo() {
    }

    public Photo(String path, List<Request> requests) {
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

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
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
