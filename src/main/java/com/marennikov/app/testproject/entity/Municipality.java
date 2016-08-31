package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "municipality")
public class Municipality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "municipality_id")
    private Integer id;

    @Column(name = "name",  nullable = false)
    private String name;

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

    public Municipality() {
    }

    public Municipality(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Municipality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
