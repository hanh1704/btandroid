package com.example.quanlibanhang;

public class KhachHang {

    private String maKH;
    private String tenKH, DiaChi, SDT;
    byte[] hinhanh;

    public KhachHang() {

    }
    public KhachHang(String maKH, String tenKH, String diaChi, String SDT,  byte[] hinhanh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.DiaChi = diaChi;
        this.SDT = SDT;
        this.hinhanh=hinhanh;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return  maKH;

    }
}

