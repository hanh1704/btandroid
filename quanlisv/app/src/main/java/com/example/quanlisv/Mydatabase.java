package com.example.quanlisv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Mydatabase {
    SQLiteDatabase database;
    DBHelper myHelper;
    public Mydatabase (Context context)
    {
        myHelper=new DBHelper(context);
        try {
            database=myHelper.getWritableDatabase();
        }
        catch (SQLiteException ex)
        {
            database=myHelper.getReadableDatabase();
        }
    }
//    public void close()
//    {
//        myHelper.close();
//
//    }
    public Cursor LayTatCaDuLieu () {
        String[] cot = {myHelper.COT_ID, myHelper.COT_TEN, myHelper.COT_LOP};
        Cursor cursor = null;//contro tro toi tung hang ketqua
        cursor = database.query(myHelper.TEN_BANG_SINHVIEN, cot, null, null, null, null, myHelper.COT_ID + " DESC");
        return cursor;
    }
    public long Them (sinhvien sv) {
        ContentValues values = new ContentValues();
        values.put(myHelper.COT_TEN, sv.getTen());
        values.put(myHelper.COT_LOP, sv.getLop());
       return database.insert(myHelper.TEN_BANG_SINHVIEN, null, values);

    }
    public long Xoa (sinhvien sv) {
        return database.delete(DBHelper.TEN_BANG_SINHVIEN, DBHelper.COT_TEN + "=" + "'" + sv.getTen() + "'", null);
    }
    public long Sua (sinhvien sv)
    {
        ContentValues values =new ContentValues();
        values.put(DBHelper.COT_TEN,sv.getTen());
        values.put(DBHelper.COT_LOP, sv.getLop());
        return database.update(DBHelper.TEN_BANG_SINHVIEN, values,
                DBHelper.COT_ID + " = " + sv.getId(), null);


    }
}
