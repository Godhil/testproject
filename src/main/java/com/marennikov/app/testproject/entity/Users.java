package com.marennikov.app.testproject.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private Integer password;

    @Column(name = "surname")
    private String surname;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "role")
    private Integer role;

    @ManyToMany(mappedBy = "users")
    private List<Municipality> municipalityId;

    @ManyToOne()
    @JoinColumn(name = "requester")
    private Requests requestRequester;

    @ManyToOne()
    @JoinColumn(name = "assignee")
    private Requests requestAssignee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public List<Municipality> getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(List<Municipality> municipalityId) {
        this.municipalityId = municipalityId;
    }

    public Requests getRequestRequester() {
        return requestRequester;
    }

    public void setRequestRequester(Requests requestRequester) {
        this.requestRequester = requestRequester;
    }

    public Requests getRequestAssignee() {
        return requestAssignee;
    }

    public void setRequestAssignee(Requests requestAssignee) {
        this.requestAssignee = requestAssignee;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", role=" + role +
                ", municipalityId=" + municipalityId +
                '}';
    }
}
