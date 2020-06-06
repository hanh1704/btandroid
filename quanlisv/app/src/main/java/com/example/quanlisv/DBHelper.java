package com.example.quanlisv;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TEN_DATABASE = "QuanLySinhVien";
    public static final String TEN_BANG_SINHVIEN ="SinhVien";
    public static final String COT_ID ="_id";
    public static final String COT_TEN ="_ten";
    public static final String COT_LOP ="_lop";
    private static final String TAO_BANG_SINHVIEN =""+"create table "+TEN_BANG_SINHVIEN+"("+COT_ID +" integer primary key autoincrement ," +COT_TEN+" text not null, "+COT_LOP+" text not null );";
    public DBHelper (Context context)
    {
        super(context,TEN_DATABASE,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_SINHVIEN);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TEN_BANG_SINHVIEN);
//        db.execSQL(drop_students_table);
//
//        onCreate(db);

    }
}
