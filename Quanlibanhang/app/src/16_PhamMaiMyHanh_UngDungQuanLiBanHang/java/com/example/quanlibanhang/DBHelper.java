package com.example.quanlibanhang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TEN_DATABASE = "QuanLyBanHang";
    public static final String TEN_BANG ="Mathang";
    public static final String COT_MA_HANG_HOA ="_id";
    public static final String COT_TEN ="_ten";
    public static final String COT_DONVI ="_dv";
    public static final String COT_GIA ="_gia";
    public static final String COT_SOLUONG ="_soluong";
    public static final String COT_HINHANH ="_hinhanh";

    private static final String TAO_BANG_HANGHOA =""+"create table "+TEN_BANG+"("+COT_MA_HANG_HOA +" integer primary key autoincrement, " +COT_TEN+" text not null, "+COT_DONVI+" text not null, "+COT_GIA+" text not null, "+COT_SOLUONG+" text not null, "+COT_HINHANH+" text not null );";

    public static final String TEN_BANG_NHANVIEN ="nhanvien";
    public static final String COT_USER ="_user";
    public static final String COT_PASS ="_pass";
    public static final String COT_TENNV ="_ten";
    public static final String COT_Sdt ="_sdt";
    public static final String COT_diachiNV ="_diachi";
    public static final String COT_chucvu="_chucvu";
    public static final String COT_HINHANHNV ="_hinhanh";
    private static final String TAO_BANG_NHANVIEN =""+"create table "+TEN_BANG_NHANVIEN+"("+COT_USER +" string primary key , " +COT_PASS+" text not null, "+COT_TENNV+" text not null, "+COT_Sdt+" text not null, "+COT_diachiNV+" text not null, "+COT_chucvu+" text not null, "+COT_HINHANHNV+" text not null);";

    public static final String TEN_BANG_KHACH_HANG ="_kh";
    public static final String COT_MA_KH ="_id";
    public static final String COT_Ten ="_ten";
    public static final String COT_diachi ="_dc";
    public static final String COT_sdt ="_sdt";
    public static final String COT_HINHANHKH ="_hinhanh";
    private static final String TAO_BANG_KHACHHANG =""+"create table "+TEN_BANG_KHACH_HANG+"("+COT_MA_KH+" integer primary key autoincrement, "+COT_TEN+" text not null, " +COT_diachi+" text not null, "+COT_sdt+" text not null, "+COT_HINHANHKH+" text not null );";

    public static final String TEN_BANG_HOA_DON ="_hd";
    public static final String COT_MA_HD ="_id";
    public static final String COT_Ngaylap ="_ngaylap";
    public static final String COT_MaKh ="_makh";
    public static final String COT_spHD ="_sp";
    public static final String COT_soluongban ="_soluongban";
    public static final String COT_thanhtien ="_thanhtien";
    private static final String TAO_BANG_HOA_DON =""+"create table "+TEN_BANG_HOA_DON+"("+COT_MA_HD+" integer primary key autoincrement, "+COT_Ngaylap+" text not null, "+COT_MaKh+" text not null , "+COT_spHD+" text not null, "+COT_soluongban+" text not null, "+COT_thanhtien+" text not null );";

    public DBHelper(Context context)
    {
        super(context,TEN_DATABASE,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TAO_BANG_HANGHOA);
        db.execSQL(TAO_BANG_KHACHHANG);
        db.execSQL(TAO_BANG_HOA_DON);
        db.execSQL(TAO_BANG_NHANVIEN);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TEN_BANG_SINHVIEN);
//        db.execSQL(drop_students_table);
//
//        onCreate(db);

    }
}
