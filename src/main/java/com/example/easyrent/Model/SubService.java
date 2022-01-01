package com.example.easyrent.Model;

import javax.persistence.*;
@Entity
@Table(name="subservices")
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    public int id;
    @Column(name= "type")
    public String type;
    @Column(name= "service")
    public String service;
    @Column(name= "subservice")
    public String subservice;
    @Column(name= "img")
    public String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSubservice() {
        return subservice;
    }

    public void setSubservice(String subservice) {
        this.subservice = subservice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
