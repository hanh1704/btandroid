package com.example.quanlibanhang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class database {
    SQLiteDatabase database;
    DBHelper myHelper;

    public database(Context context) {
        myHelper = new DBHelper(context);
        try {
            database = myHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            database = myHelper.getReadableDatabase();
        }
    }

    //    public void close()
//    {
//        myHelper.close();
//
//    }
    public Cursor LayTatCaDuLieuMatHang() {
        String[] cot = {myHelper.COT_MA_HANG_HOA, myHelper.COT_TEN, myHelper.COT_DONVI, myHelper.COT_GIA, myHelper.COT_SOLUONG,myHelper.COT_HINHANH};
        Cursor cursor = null;//contro tro toi tung hang ketqua
        cursor = database.query(myHelper.TEN_BANG, cot, null, null, null, null, myHelper.COT_MA_HANG_HOA + " DESC");
        return cursor;
    }
    public Cursor layGia(String mahang)
    {
        String areaTyp = "SELECT " +myHelper.COT_GIA + "  FROM "
                + myHelper.TEN_BANG + " where `" + myHelper.COT_MA_HANG_HOA+ "`="
                + mahang;
        Cursor c = database.rawQuery( "SELECT * FROM Mathang WHERE _id = '"+mahang+"'", null);
       // Cursor c = database.rawQuery(areaTyp,new String[] {myHelper.COT_MA_HANG_HOA});
        return c;
    }
        public long ThemMatHang (MatHang mh){
            ContentValues values = new ContentValues();
            values.put(myHelper.COT_TEN, mh.getTenHang());
            values.put(myHelper.COT_DONVI, mh.getDonviHang());
            values.put(myHelper.COT_GIA, mh.getGiaHang());
            values.put(myHelper.COT_SOLUONG, mh.getSoluongHang());
            values.put(myHelper.COT_HINHANH,mh.getHinhanh());
            return database.insert(myHelper.TEN_BANG, null, values);

        }

        public long XoaMatHang (MatHang mh){
            return database.delete(DBHelper.TEN_BANG, DBHelper.COT_MA_HANG_HOA + "=" + "'" + mh.getMaHang() + "'", null);
        }

        public long suaMatHang (MatHang mh){
            ContentValues values = new ContentValues();
            values.put(DBHelper.COT_TEN, mh.getTenHang());
            values.put(DBHelper.COT_DONVI, mh.getDonviHang());
            values.put(DBHelper.COT_GIA, mh.getGiaHang());
            values.put(DBHelper.COT_SOLUONG, mh.getSoluongHang());
            values.put(myHelper.COT_HINHANH,mh.getHinhanh());
            return database.update(DBHelper
                            .TEN_BANG, values,
                    DBHelper.COT_MA_HANG_HOA + " = "
                            + mh.getMaHang(), null);

        }
        public long updatesoluong (String sl, String ma)
        {
            ContentValues values = new ContentValues();
            values.put(DBHelper.COT_SOLUONG, sl);
            return database.update(DBHelper
                            .TEN_BANG, values,
                    DBHelper.COT_MA_HANG_HOA + " = "
                            + ma, null);

        }
        public Cursor LayTatCaDuLieuKhachHang () {
            String[] cot = {myHelper.COT_MA_KH, myHelper.COT_Ten, myHelper.COT_diachi, myHelper.COT_sdt,myHelper.COT_HINHANHKH};
            Cursor cursor = null;//contro tro toi tung hang ketqua
            cursor = database.query(myHelper.TEN_BANG_KHACH_HANG, cot, null, null, null, null, myHelper.COT_MA_KH + " DESC");
            return cursor;
        }
        public long ThemKhachHang (KhachHang kh){
            ContentValues values = new ContentValues();
            values.put(myHelper.COT_Ten, kh.getTenKH());
            values.put(myHelper.COT_diachi, kh.getDiaChi());
            values.put(myHelper.COT_sdt, kh.getSDT());
            values.put(myHelper.COT_HINHANHKH,kh.getHinhanh());
            return database.insert(myHelper.TEN_BANG_KHACH_HANG, null, values);

        }

        public long XoaKhachHang (KhachHang kh){
            return database.delete(DBHelper.TEN_BANG_KHACH_HANG, DBHelper.COT_MA_KH + "=" + "'" + kh.getMaKH() + "'", null);
        }

        public long suaKhachHang (KhachHang kh){
            ContentValues values = new ContentValues();
            values.put(myHelper.COT_Ten, kh.getTenKH());
            values.put(myHelper.COT_diachi, kh.getDiaChi());
            values.put(myHelper.COT_sdt, kh.getSDT());
            values.put(myHelper.COT_HINHANHKH,kh.getHinhanh());
            return database.update(DBHelper
                            .TEN_BANG_KHACH_HANG, values,
                    DBHelper.COT_MA_KH + " = "
                            + kh.getMaKH(), null);

        }
//    public Cursor LayTatCaDuLieuCTHD () {
//        String[] cot = {myHelper.COT_MA_SP, myHelper.COT_Ten_sp, myHelper.COT_soluongmua, myHelper.COT_thanhtien, myHelper.COT_MaHD};
//        Cursor cursor = null;//contro tro toi tung hang ketqua
//        cursor = database.query(myHelper.TEN_BANG_CTHD, cot, null, null, null, null, myHelper.COT_MaHD+ " DESC");
//        return cursor;
//    }
//    public long ThemCTHD(ChiTietHoaDon hd){
//        ContentValues values = new ContentValues();
//        values.put(myHelper.COT_MA_SP, hd.getMaspCTHD());
//        values.put(myHelper.COT_Ten_sp, hd.getTenspCTHD());
//        values.put(myHelper.COT_soluongmua, hd.getSoluongbanCTHD());
//        values.put(myHelper.COT_thanhtien, hd.getThanhtienCTHD());
//        values.put(myHelper.COT_MaHD, hd.getMahdCTHD());
//        return database.insert(myHelper.TEN_BANG_CTHD, null, values);
//
//    }
//
//    public long XoaCTHD (ChiTietHoaDon hd){
//        return database.delete(DBHelper.TEN_BANG_CTHD, DBHelper.COT_MaHD + "=" + "'" + hd.getMahdCTHD() + "'" + DBHelper.COT_MA_SP + "=" +"'" +hd.getMaspCTHD() + "'", null);
//
//    }
//
//    public long suaCTHD (ChiTietHoaDon hd){
//        ContentValues values = new ContentValues();
//        values.put(myHelper.COT_MA_SP, hd.getMaspCTHD());
//        values.put(myHelper.COT_Ten_sp, hd.getTenspCTHD());
//        values.put(myHelper.COT_soluongmua, hd.getSoluongbanCTHD());
//        values.put(myHelper.COT_thanhtien, hd.getThanhtienCTHD());
//        values.put(myHelper.COT_MaHD, hd.getMahdCTHD());
//        return database.update(DBHelper
//                        .TEN_BANG_CTHD, values,
//                DBHelper.COT_MaHD + " = "
//                        + hd.getMahdCTHD() + DBHelper.COT_MA_SP + "=" +"'" +hd.getMaspCTHD() + "'", null);
//
//    }
    public Cursor LayTatCaDuLieuHoaDon () {
        String[] cot = {myHelper.COT_MA_HD, myHelper.COT_Ngaylap, myHelper.COT_MaKh, myHelper.COT_spHD, myHelper.COT_soluongban, myHelper.COT_thanhtien};
        Cursor cursor = null;//contro tro toi tung hang ketqua
        cursor = database.query(myHelper.TEN_BANG_HOA_DON, cot, null, null, null, null, myHelper.COT_MA_HD+ " DESC");
        return cursor;
    }
    public long ThemHoaDON (HoaDon hd){
        ContentValues values = new ContentValues();
        values.put(myHelper.COT_Ngaylap, hd.getNgayLap());
        values.put(myHelper.COT_MaKh, hd.getMakhHD());
        values.put(myHelper.COT_spHD, hd.getTenspHD());
        values.put(myHelper.COT_soluongban, hd.getSoluongHD());
        values.put(myHelper.COT_thanhtien, hd.getThanhtienHD());

        return database.insert(myHelper.TEN_BANG_HOA_DON, null, values);

    }

    public long XoaHoaDon (HoaDon hd){
        return database.delete(DBHelper.TEN_BANG_HOA_DON, DBHelper.COT_MA_HD + "=" + "'" + hd.getSoHD() + "'", null);
    }

    public long suaHoaDon (HoaDon hd){
        ContentValues values = new ContentValues();
        values.put(myHelper.COT_Ngaylap, hd.getNgayLap());
        values.put(myHelper.COT_MaKh, hd.getMakhHD());
        values.put(myHelper.COT_spHD, hd.getTenspHD());
        values.put(myHelper.COT_soluongban, hd.getSoluongHD());
        values.put(myHelper.COT_thanhtien, hd.getThanhtienHD());
        return database.update(DBHelper
                        .TEN_BANG_HOA_DON, values,
                DBHelper.COT_MA_HD + " = "
                        + hd.getSoHD(), null);

    }
    public Cursor LayTatCaDuLieuNhanVien () {
        String[] cot = {myHelper.COT_USER, myHelper.COT_PASS, myHelper.COT_TENNV, myHelper.COT_Sdt,myHelper.COT_diachiNV,myHelper.COT_chucvu,myHelper.COT_HINHANHNV};
        Cursor cursor = null;//contro tro toi tung hang ketqua
        cursor = database.query(myHelper.TEN_BANG_NHANVIEN, cot, null, null, null, null, null);
        return cursor;
    }
    public long ThemNhanvien (Nhanvien kh){
        ContentValues values = new ContentValues();
        values.put(myHelper.COT_USER, kh.getUsername());
        values.put(myHelper.COT_PASS, kh.getPass());
        values.put(myHelper.COT_TENNV, kh.getTen());
        values.put(myHelper.COT_Sdt, kh.getSdt());
        values.put(myHelper.COT_diachiNV, kh.getDiachi());
        values.put(myHelper.COT_chucvu, kh.getChucvu());
        values.put(myHelper.COT_HINHANHNV,kh.getHinhanh());
        return database.insert(myHelper.TEN_BANG_NHANVIEN, null, values);

    }

    public long XoaNhanVien (Nhanvien kh){
        return database.delete(DBHelper.TEN_BANG_NHANVIEN, DBHelper.COT_USER + "=" + "'" + kh.getUsername() + "'", null);
    }

    public long suaNhanVien (Nhanvien kh){
        ContentValues values = new ContentValues();
      //  values.put(myHelper.COT_USER, kh.getUsername());
        values.put(myHelper.COT_PASS, kh.getPass());
        values.put(myHelper.COT_TENNV, kh.getTen());
        values.put(myHelper.COT_Sdt, kh.getSdt());
        values.put(myHelper.COT_diachiNV, kh.getDiachi());
        values.put(myHelper.COT_chucvu, kh.getChucvu());
        values.put(myHelper.COT_HINHANHNV,kh.getHinhanh());
        return database.update(DBHelper
                        .TEN_BANG_NHANVIEN, values,
                DBHelper.COT_USER + " LIKE '"+kh.getUsername() +"'", null);

    }

    public Cursor CheckLogin(String user, String pass)
    {
        Cursor c = database.rawQuery( "SELECT * FROM nhanvien WHERE _user = '"+user+"' AND _pass ='"+pass+"'" , null);
        // Cursor c = database.rawQuery(areaTyp,new String[] {myHelper.COT_MA_HANG_HOA});
        return c;
    }
    public Cursor CheckDS(String nam)
    {
        //Toast.makeText(getClass(),nam,Toast.LENGTH_LONG).show();
        Cursor c = null;
         c = database.rawQuery( "SELECT * FROM _hd WHERE _ngaylap LIKE '%"+nam+"%'" , null);
       // Cursor c = database.rawQuery( "SELECT * FROM _hd " , null);
        // Cursor c = database.rawQuery(areaTyp,new String[] {myHelper.COT_MA_HANG_HOA});

        return c;
    }
    public Cursor checkHangBanChay(String ngay)
    {
        Cursor c=null;
        c=database.rawQuery("SELECT * FROM _hd WHERE _ngaylap LIKE '%"+ngay+"%' GROUP BY _sp ORDER BY SUM(_soluongban) DESC ",null);
      //  c=database.rawQuery("SELECT * FROM _hd WHERE _sp = (SELECT _sp FROM _hd GROUP BY _sp ORDER BY SUM(_soluongban) DESC LIMIT 10) ",null);AND _ngaylap LIKE '%"+ngay+"%' "

        return c;
    }
    public Cursor checkKhachHangMuaNhieuNhat(String ngay)
    {
        Cursor c=null;
        c=database.rawQuery("SELECT * FROM _hd WHERE _ngaylap LIKE '%"+ngay+"%' GROUP BY _makh ORDER BY SUM(_soluongban) DESC ",null);

        return c;
    }
    public Cursor layTenKH(String makh)
    {
        Cursor c = database.rawQuery( "SELECT * FROM _kh WHERE _id = '"+makh+"'", null);
        // Cursor c = database.rawQuery(areaTyp,new String[] {myHelper.COT_MA_HANG_HOA});
        return c;
    }
    }

