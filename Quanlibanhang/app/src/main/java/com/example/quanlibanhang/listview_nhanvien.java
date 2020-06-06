package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listview_nhanvien   extends AppCompatActivity {
    ListView listNV;
    Button addbt,editbt,deletebt,exitbt;
    database dataNhanvien;
    int vitri=-1;
    ArrayList<Nhanvien> data = new ArrayList<Nhanvien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_nhanvien);
        setControl();
        setEvent();

    }
    public void setControl()
    {
        listNV=findViewById(R.id.nhanvien_listview);
        addbt=findViewById(R.id.addNV);
        editbt=findViewById(R.id.editNV);
        deletebt=findViewById(R.id.deleteNV);
        exitbt=findViewById(R.id.exitNV);
    }
    public void setEvent()
    {
        final nhanvienAdapter adapterkhachhang=new nhanvienAdapter(this,R.layout.item_nhanvien,data);
        dataNhanvien = new database(this);
        listNV.setAdapter(adapterkhachhang);
        Cursor cursor = dataNhanvien.LayTatCaDuLieuNhanVien();
        if (cursor != null) {
            data.clear();
            while (cursor.moveToNext()) {
                Nhanvien kh = new Nhanvien();
                kh.setUsername(cursor.getString(0));
                kh.setPass(cursor.getString(1));
                kh.setTen(cursor.getString(2));
                kh.setSdt( cursor.getString(3));
                kh.setDiachi( cursor.getString(4));
              //  kh.setRole( cursor.getString(5));
                kh.setChucvu( cursor.getString(5));
                kh.setHinhanh(cursor.getBlob(6));
                data.add(kh);
            }
            adapterkhachhang.notifyDataSetChanged();

        }
        exitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(listview_nhanvien.this, menu.class);
                startActivity(intent);
            }
        });
        listNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vitri=position;
//                for (int i = 0; i < listNV.getChildCount(); i++) {
//                    if(position == i ){
//
//                        listNV.getChildAt(i).setBackgroundColor(Color.rgb(204,240,244));
//                    }else{
//                        listNV.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
//                    }
//                }

            }
        });
        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(listview_nhanvien.this,activity_nhanvien.class);
                intent.putExtra("vitriNV",vitri);
                intent.putExtra("roleNV",-1);
                startActivity(intent);
            }
        });
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(listview_nhanvien.this,activity_nhanvien.class);
                startActivity(intentt);
            }
        });
        deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Nhanvien kh=data.get(vitri);
                dataNhanvien.XoaNhanVien(kh);
                data.remove(vitri);
                adapterkhachhang.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();

            }
        });

    }
}
