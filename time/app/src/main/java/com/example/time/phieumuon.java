package com.example.time;

public class phieumuon {
    private String sophieumuon,ngaymuon,ghichu,docgia,tensach;

    public phieumuon(String sophieumuon, String ngaymuon, String ghichu, String docgia, String tensach) {
        this.sophieumuon = sophieumuon;
        this.ngaymuon = ngaymuon;
        this.ghichu = ghichu;
        this.docgia = docgia;
        this.tensach = tensach;
    }
    public phieumuon()
    {}

    public String getSophieumuon() {
        return sophieumuon;
    }

    public void setSophieumuon(String sophieumuon) {
        this.sophieumuon = sophieumuon;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getDocgia() {
        return docgia;
    }

    public void setDocgia(String docgia) {
        this.docgia = docgia;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    @Override
    public String toString() {
        return sophieumuon+"\n"+ngaymuon+"\n"+ghichu+"\n"+docgia+"\n"+tensach;
    }
}
