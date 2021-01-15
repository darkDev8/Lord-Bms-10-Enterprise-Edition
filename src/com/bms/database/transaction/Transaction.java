package com.bms.database.transaction;


public class Transaction {
    private int id;
    private int fid;
    
    private String sourcean;
    private String destacn;
    private String date;
    
    private short type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getSourcean() {
        return sourcean;
    }

    public void setSourcean(String sourcean) {
        this.sourcean = sourcean;
    }

    public String getDestacn() {
        return destacn;
    }

    public void setDestacn(String destacn) {
        this.destacn = destacn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }
    
    
}
