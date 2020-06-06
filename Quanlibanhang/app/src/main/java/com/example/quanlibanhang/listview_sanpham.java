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

public class listview_sanpham  extends AppCompatActivity {
    ListView listSP;
    Button addbt,editbt,deletebt,exitbt;
    database datamathang;
    int vitri=-1;
  ArrayList <MatHang> data = new ArrayList<MatHang>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_sp);
       setControl();
        setEvent();

    }
    public void setControl()
    {
        listSP=findViewById(R.id.sanpham_listview);
        addbt=findViewById(R.id.addSP);
        editbt=findViewById(R.id.editSP);
        deletebt=findViewById(R.id.deleteSP);
        exitbt=findViewById(R.id.exitSP);
    }
  //  public static databaseMatHang database;
    public void setEvent() {
        Intent intent =getIntent();
        final String role = intent.getStringExtra("role");
        final sanphamAdapter adaptermatHang=new sanphamAdapter(this,R.layout.item_mathang,data);
        datamathang = new database(this);
            listSP.setAdapter(adaptermatHang);

        Cursor cursor = datamathang.LayTatCaDuLieuMatHang();
        if (cursor != null) {
            data.clear();
            while (cursor.moveToNext()) {
                MatHang mh = new MatHang();
                mh.setMaHang("" + cursor.getInt(0));
                mh.setTenHang(cursor.getString(1));
                mh.setDonviHang(cursor.getString(2));
                mh.setGiaHang("" + cursor.getFloat(3));
                mh.setSoluongHang("" + cursor.getInt(4));
                mh.setHinhanh(cursor.getBlob(5));
                data.add(mh);
            }
            adaptermatHang.notifyDataSetChanged();

        }


        exitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(listview_sanpham.this, menu.class);
                intent.putExtra("roleN",role);
                startActivity(intent);
            }
        });
        listSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vitri=position;
//                for (int i = 0; i < listSP.getChildCount(); i++) {
//                    if(position == i ){
//
//                        listSP.getChildAt(i).setBackgroundColor(Color.rgb(204,240,244));
//                    }else{
//                        listSP.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
//                    }
//                }

            }
        });
        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(listview_sanpham.this,activity_mathang.class);
                intent.putExtra("vitri",vitri);
                intent.putExtra("role",-1);
                startActivity(intent);
            }
        });
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(listview_sanpham.this,activity_mathang.class);
                startActivity(intentt);
            }
        });
        deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        MatHang mh=data.get(vitri);
                        datamathang.XoaMatHang(mh);
                        data.remove(vitri);
                        adaptermatHang.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();

                    }
                });




    }
}

