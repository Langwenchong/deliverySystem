package com.example.deliverysystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author Lang wenchong
 * @Date 2021/12/25 16:22
 * @Version 1.0
 */

@Entity
@Table(name = "MyUtils")
public class MyUtils {

    @Id
    @Column(name = "uid")
    private String uid;

    @Column(name = "cid")
    private int cid;

    public MyUtils() {
    }

    public MyUtils(String uid, int cid) {
        this.uid = uid;
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
