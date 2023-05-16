package com.courier.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courier_table")
public class RegisterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  int courier_id;
    private String cname;
    private String sname;
    private String sphone;
    private String email;
    private String rname;
    private String rphone;
    private String route;
    private String transport;


    public RegisterModel() {
    }

    public RegisterModel(int id, int courier_id, String cname, String sname, String sphone, String email, String rname, String rphone, String route, String transport) {
        this.id = id;
        this.courier_id = courier_id;
        this.cname = cname;
        this.sname = sname;
        this.sphone = sphone;
        this.email = email;
        this.rname = rname;
        this.rphone = rphone;
        this.route = route;
        this.transport = transport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRphone() {
        return rphone;
    }

    public void setRphone(String rphone) {
        this.rphone = rphone;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "RegisterModel{" +
                "id=" + id +
                ", courier_id=" + courier_id +
                ", cname='" + cname + '\'' +
                ", sname='" + sname + '\'' +
                ", sphone='" + sphone + '\'' +
                ", email='" + email + '\'' +
                ", rname='" + rname + '\'' +
                ", rphone='" + rphone + '\'' +
                ", route='" + route + '\'' +
                ", transport='" + transport + '\'' +
                '}';
    }
}
