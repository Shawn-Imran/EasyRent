package com.example.easyrent.Model;

import javax.persistence.*;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    public int id;
    @Column(name= "name")
    public String name;
    @Column(name= "email")
    public String email;
    @Column(name= "primarynumber")
    public String primarynumber;
    @Column(name= "secondarynumber")
    public String secondarynumber;
    @Column(name= "address")
    public String address;
    @Column(name= "city")
    public String city;
    @Column(name= "country")
    public String country;
    @Column(name= "postalcode")
    public String postalcode;
    @Column(name= "about")
    public String about;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimarynumber() {
        return primarynumber;
    }

    public void setPrimarynumber(String primarynumber) {
        this.primarynumber = primarynumber;
    }

    public String getSecondarynumber() {
        return secondarynumber;
    }

    public void setSecondarynumber(String secondarynumber) {
        this.secondarynumber = secondarynumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
