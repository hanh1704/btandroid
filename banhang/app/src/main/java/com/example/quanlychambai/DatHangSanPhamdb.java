package com.example.quanlychambai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatHangSanPhamdb {
    SQLiteDatabase database;
    DBHelper dbHelper;
    public DatHangSanPhamdb(Context context){
        dbHelper = new DBHelper(context);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            database = dbHelper.getReadableDatabase();
        }
    }
    public void close() {
        dbHelper.close();
    }
    public Cursor layTatCaDuLieu(){
        // biến cot khai bao danh sach cot can lay
        String[] cot = {DBHelper.COT_ID,
                DBHelper.COT_Ngaylap,
                DBHelper.COT_soluong,
                DBHelper.COT_sanpham,
                DBHelper.COT_khachhang};
        Cursor cursor = null;
        cursor = database.query(DBHelper.
                        TEN_BANG, cot, null, null, null, null,
                DBHelper.COT_ID + " DESC");
        return cursor;
    }
    public long them(DatHangSanPham chamBai) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_Ngaylap, chamBai.getNgaydat());
        values.put(DBHelper.COT_soluong, chamBai.getSoluong());
        values.put(DBHelper.COT_khachhang, chamBai.getKhachhang());
        values.put(DBHelper.COT_sanpham, chamBai.getSanpham());
        return database.insert(DBHelper.
                TEN_BANG, null, values);
    }
    public long xoa(DatHangSanPham chamBai) {
        return database.delete(DBHelper.TEN_BANG,
                DBHelper.COT_ID + " = " + "'" +
                chamBai.getId() + "'", null);
    }
    public long sua(DatHangSanPham chamBai) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_Ngaylap, chamBai.getNgaydat());
        values.put(DBHelper.COT_soluong, chamBai.getSoluong());
        values.put(DBHelper.COT_khachhang, chamBai.getKhachhang());
        values.put(DBHelper.COT_sanpham, chamBai.getSanpham());
        return database.update(DBHelper
                        .TEN_BANG, values,
                DBHelper.COT_ID + " = "
                        + chamBai.getId(), null);

    }
}
