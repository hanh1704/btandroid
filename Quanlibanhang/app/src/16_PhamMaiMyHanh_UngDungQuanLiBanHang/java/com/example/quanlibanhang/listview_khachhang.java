package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listview_khachhang  extends AppCompatActivity {
    ListView listKH;
    Button addbt,editbt,deletebt,exitbt;
    database dataKhachHang;
    int vitri=-1;
    ArrayList<KhachHang> data = new ArrayList<KhachHang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_khachhang);
        setControl();
        setEvent();

    }
    public void setControl()
    {
        listKH=findViewById(R.id.khachhang_listview);
        addbt=findViewById(R.id.addKH);
        editbt=findViewById(R.id.editKH);
        deletebt=findViewById(R.id.deleteKH);
        exitbt=findViewById(R.id.exitKH);
    }
    public void setEvent()
    {


        final KhachHangAdapter adapterkhachhang=new KhachHangAdapter(this,R.layout.item_khachhang,data);
        dataKhachHang = new database(this);
        listKH.setAdapter(adapterkhachhang);

        Cursor cursor = dataKhachHang.LayTatCaDuLieuKhachHang();
        if (cursor != null) {
            data.clear();
            while (cursor.moveToNext()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH("" + cursor.getInt(0));
                kh.setTenKH(cursor.getString(1));
                kh.setDiaChi(cursor.getString(2));
                kh.setSDT( cursor.getString(3));
                kh.setHinhanh(cursor.getBlob(4));
                data.add(kh);
            }
            adapterkhachhang.notifyDataSetChanged();

        }
        exitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(listview_khachhang.this, menu.class);
                intent.putExtra("roleKHH",2);
                startActivity(intent);
            }
        });
        listKH.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vitri=position;
//                for (int i = 0; i < listKH.getChildCount(); i++) {
//                    if(position == i ){
//
//                        listKH.getChildAt(i).setBackgroundColor(Color.rgb(6,155,174));
//                    }else{
//                        listKH.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
//                    }
//                }

            }
        });
        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(listview_khachhang.this,activity_khachhang.class);
                intent.putExtra("vitriKH",vitri);
                intent.putExtra("roleKH",-1);
                startActivity(intent);
            }
        });
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(listview_khachhang.this,activity_khachhang.class);
                startActivity(intentt);
            }
        });
        deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KhachHang kh=data.get(vitri);
                dataKhachHang.XoaKhachHang(kh);
                data.remove(vitri);
                adapterkhachhang.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();

            }
        });

    }
    }
