package com.example.quanlibanhang;

public class Nhanvien {
    String username,pass,ten,sdt,diachi,role,chucvu;
    byte[] hinhanh;
    public  Nhanvien()
    {

    }

    public Nhanvien(String username, String pass, String ten, String sdt, String diachi, String role, String chucvu,  byte[] hinhanh) {
        this.username = username;
        this.pass = pass;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.role = role;
        this.chucvu = chucvu;
        this.hinhanh=hinhanh;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
