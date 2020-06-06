package com.example.quanlychambai;

import androidx.annotation.NonNull;

public class DatHangSanPham {

    String id, ngaydat, soluong, sanpham, khachhang;

    public DatHangSanPham(String id, String ngaydat, String soluong, String sanpham, String khachhang) {
        this.id = id;
        this.ngaydat = ngaydat;
        this.soluong = soluong;
        this.sanpham = sanpham;
        this.khachhang = khachhang;
    }
    public DatHangSanPham()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNgaydat() {
        return ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        this.ngaydat = ngaydat;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getSanpham() {
        return sanpham;
    }

    public void setSanpham(String sanpham) {
        this.sanpham = sanpham;
    }

    public String getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(String khachhang) {
        this.khachhang = khachhang;
    }

    @Override
    public String toString() {
        return "DatHangSanPham{" +
                "id='" + id + '\'' +
                ", ngaydat='" + ngaydat + '\'' +
                ", soluong='" + soluong + '\'' +
                ", sanpham='" + sanpham + '\'' +
                ", khachhang='" + khachhang + '\'' +
                '}';
    }
}