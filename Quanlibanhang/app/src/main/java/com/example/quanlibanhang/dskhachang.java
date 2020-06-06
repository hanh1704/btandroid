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

public class dskhachang  extends AppCompatActivity {
    EditText ngay;
    Button tkhbc, exit;
    database db;
    ListView lv;
    TextView kq, sl;
    ArrayList data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dskhachhang);
        setControl();
        setEvent();


    }

    public void setControl() {
        ngay = findViewById(R.id.ngaykh);
        tkhbc = findViewById(R.id.tkkh);
        exit = findViewById(R.id.exittkh);
        // kq=findViewById(R.id.kqtkhbc);
        // sl=findViewById(R.id.soluongban);
        lv = findViewById(R.id.lvkhtk);
    }

    public void setEvent() {
        final ArrayAdapter a = new ArrayAdapter<>(this, R.layout.layouttextview, data);
        lv.setAdapter(a);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(dskhachang.this, menuthongke.class);
                startActivity(i);
            }
        });
        db = new database(this);
        tkhbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = db.checkKhachHangMuaNhieuNhat(ngay.getText().toString());
                if (cursor != null) {
                    data.clear();
                    while (cursor.moveToNext()) {
                        HoaDon hd = new HoaDon();
                        hd.setMakhHD(cursor.getString(2));
                        Cursor c=db.layTenKH(hd.getMakhHD());
                        if (c!=null){

                            while (c.moveToNext()){
                                KhachHang kh=new KhachHang();
                                kh.setTenKH(c.getString(1));
                                data.add(kh.getTenKH());
                            }
                            a.notifyDataSetChanged();
                        }

                    }


                }


            }
        });

    }
}
