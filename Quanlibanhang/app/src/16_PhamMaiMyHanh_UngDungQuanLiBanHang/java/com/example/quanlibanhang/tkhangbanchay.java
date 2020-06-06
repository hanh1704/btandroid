package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class tkhangbanchay extends AppCompatActivity {
    EditText ngay;
    Button tkhbc, exit;
    database db;
    ListView lv;
    TextView kq,sl;
    ArrayList data =new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hangbanchay);
        setControl();
        setEvent();


    }
    public void setControl()
    {
        ngay=findViewById(R.id.ngay);
        tkhbc=findViewById(R.id.tkhangbanchay);
        exit=findViewById(R.id.exittkhbc);
       // kq=findViewById(R.id.kqtkhbc);
       // sl=findViewById(R.id.soluongban);
        lv=findViewById(R.id.lvtk);
    }

    public void setEvent(){
       final ArrayAdapter a=new ArrayAdapter<>(this,R.layout.layouttextview,data);
        lv.setAdapter(a);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tkhangbanchay.this,menuthongke.class);
                startActivity(i);
            }
        });
        db=new database(this);
        tkhbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = db.checkHangBanChay(ngay.getText().toString());
                if (cursor != null)

                {
                    data.clear();

                    while (cursor.moveToNext())
                    {
                        HoaDon hd = new HoaDon();
                        hd.setTenspHD(cursor.getString(3));
                        data.add(hd.getTenspHD());

                    }
                    a.notifyDataSetChanged();
                }





            }
        });

    }
}