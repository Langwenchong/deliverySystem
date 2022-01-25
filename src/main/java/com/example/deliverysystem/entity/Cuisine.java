package com.example.deliverysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:06
 * @Version 1.0
 */


@Entity
@Table(name = "Cuisine")
public class Cuisine {

    @Id
    @Column(name = "cid")
    private int cid;

    @Column(name = "name")
    private String name;

    @Column(name = "descr")
    private String descr;

    @Column(name = "price")
    private int price;

    @Column(name = "imgPath")
    private String imgPath;

    public Cuisine() {
    }

    public Cuisine(int cid, String name, String descr, int price, String imgPath) {
        this.cid = cid;
        this.name = name;
        this.descr = descr;
        this.price = price;
        this.imgPath = imgPath;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
