package com.example.quanlisv;

import androidx.annotation.NonNull;

public class sinhvien {
    private int id;
    private String ten, lop;

    public sinhvien(int id, String ten, String lop) {
        this.id = id;
        this.ten = ten;
        this.lop = lop;
    }
    public sinhvien ()
    {

    }

   // public sinhvien(String ten,String)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @NonNull
    @Override
    public String toString() {
        return ten+" "+lop;
    }
}

