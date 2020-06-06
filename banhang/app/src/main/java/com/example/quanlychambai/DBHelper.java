package com.example.quanlychambai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //tên cơ sở dữ liệu
    public static final String TEN_DATABASE="QuanLyDatHangSanPham";
    //tên bảng
    public static final String TEN_BANG = "DatHang";
    // khai báo cột trong bảng
    public static final String COT_ID = "_id";
    public static final String COT_Ngaylap = "_ngaylap";
    public static final String COT_soluong = "_soluong";
    public static final String COT_sanpham = "_sanpham";
    public static final String COT_khachhang = "_khachhang";
    private static final String TAO_BANG="" + " create table " + TEN_BANG + " ( "
            + COT_ID + " integer primary key autoincrement,"
            + COT_Ngaylap+ " text not null, "
            + COT_soluong + " text not null, "
            + COT_sanpham + " text not null, "
            + COT_khachhang + " text not null )";

    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }
@Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TAO_BANG);
    }
@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
