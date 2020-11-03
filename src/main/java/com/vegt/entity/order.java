package com.vegt.entity;

import java.security.Timestamp;

public class order {
    private String cid ;            //订单编号
    private String cname;       //创建人
    private String ctime;      //创建时间
    private String ctype;     //订单类型
    private String comments; //备注

    public String getCid() {
        return cid;
    }

    public order() {
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "order{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ctime='" + ctime + '\'' +
                ", ctype='" + ctype + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }



    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
