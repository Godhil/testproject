package com.marennikov.app.testproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "login",  nullable = false)
    private String login;

    @Column(name = "password",  nullable = false)
    private Integer password;

    @Column(name = "surname",  nullable = false)
    private String surname;

    @Column(name = "first_name",  nullable = false)
    private String firstName;

    @Column(name = "second_name",  nullable = false)
    private String secondName;

    @Column(name = "role",  nullable = false)
    private Integer role;

    @ManyToOne
    @JoinColumn(name = "municipality_id")
    private Municipality municipality;

    public User() {
    }

    public User(
            String login,
            Integer password,
            String surname,
            String firstName,
            String secondName,
            Integer role,
            Municipality municipality) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.municipality = municipality;
    }

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

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", role=" + role +
                ", municipality=" + municipality +
                '}';
    }
}
