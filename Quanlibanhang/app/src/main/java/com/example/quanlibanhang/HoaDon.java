package com.example.quanlibanhang;

public class HoaDon {
    private String soHD;
    private String ngayLap, makhHD, tenspHD, soluongHD, thanhtienHD;

    public HoaDon() {

    }

    public HoaDon(String soHD, String ngayLap, String makhHD, String tenspHD, String soluongHD, String thanhtienHD) {
        this.soHD = soHD;
        this.ngayLap = ngayLap;
        this.makhHD = makhHD;
        this.tenspHD = tenspHD;
        this.soluongHD = soluongHD;
        this.thanhtienHD = thanhtienHD;
    }

    public String getSoHD() {
        return soHD;
    }

    public void setSoHD(String soHD) {
        this.soHD = soHD;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getMakhHD() {
        return makhHD;
    }

    public void setMakhHD(String makhHD) {
        this.makhHD = makhHD;
    }

    public String getTenspHD() {
        return tenspHD;
    }

    public void setTenspHD(String tenspHD) {
        this.tenspHD = tenspHD;
    }

    public String getSoluongHD() {
        return soluongHD;
    }

    public void setSoluongHD(String soluongHD) {
        this.soluongHD = soluongHD;
    }

    public String getThanhtienHD() {
        return thanhtienHD;
    }

    public void setThanhtienHD(String thanhtienHD) {
        this.thanhtienHD = thanhtienHD;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "thanhtienHD='" + thanhtienHD + '\'' +
                '}';
    }
}