package com.example.easyrent.Model;

import javax.persistence.*;

@Entity
@Table(name="deals")
public class Deals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    public int id;
    @Column(name= "sid")
    public String sid;
    @Column(name= "email")
    public String email;
    @Column(name= "name")
    public String name;
    @Column(name= "number")
    public String number;
    @Column(name= "address")
    public String address;
    @Column(name= "status")
    public String status;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
