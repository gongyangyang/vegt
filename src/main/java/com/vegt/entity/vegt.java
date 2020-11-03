package com.vegt.entity;

import java.sql.Date;

public class vegt {

    private String vid;
    private String vname;
    private Double vprice;
    private String bname;
    private String address;
    private String vtime;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Double getVprice() {
        return vprice;
    }

    public void setVprice(Double vprice) {
        this.vprice = vprice;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    @Override
    public String toString() {
        return "vegt{" +
                "vid='" + vid + '\'' +
                ", vname='" + vname + '\'' +
                ", vprice=" + vprice +
                ", bname='" + bname + '\'' +
                ", address='" + address + '\'' +
                ", vtime=" + vtime +
                '}';
    }
}
