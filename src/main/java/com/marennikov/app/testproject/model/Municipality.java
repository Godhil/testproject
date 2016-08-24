package com.marennikov.app.testproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipality")
public class Municipality {

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private AdsPlace adsPlace;

    @ManyToMany
    @JoinTable(name="municipality_users",
            joinColumns = @JoinColumn(name="municipality_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="users_id", referencedColumnName="id"))
    private List<Users> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdsPlace getAdsPlace() {
        return adsPlace;
    }

    public void setAdsPlace(AdsPlace adsPlace) {
        this.adsPlace = adsPlace;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
