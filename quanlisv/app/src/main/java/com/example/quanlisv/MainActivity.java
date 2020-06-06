package com.example.quanlisv;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText Ten,Lop;
    ListView Lv;
    Button add, edit, delete;
    ArrayList<sinhvien> sinhVienArrayList = new ArrayList<>();
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        Ten=findViewById(R.id.ten);
        Lop=findViewById(R.id.lop);
        add=findViewById(R.id.Add);
       edit=findViewById(R.id.Edit);
       delete=findViewById(R.id.Delete);
       Lv=findViewById(R.id.listview);

    }
    public void setEvent()
    {
        database=new Mydatabase(this);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,sinhVienArrayList);
        Lv.setAdapter(arrayAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // layDuLieuNguoiDung();
                them();
               capNhatDuLieu();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
//lay du lieu o giao dien de xu li
    public sinhvien layDuLieuNguoiDung() {
        String TEN,LOP;
        TEN=Ten.getText().toString();
        LOP=Lop.getText().toString();

        if (TEN.trim().length() == 0
                || LOP.trim().length() == 0)
            return null;
        sinhvien sinhVien = new sinhvien();
        //sinhVien.setId();
        sinhVien.setTen(TEN);
        sinhVien.setLop(LOP);
      //  sinhVienArrayList.add(sinhVien);
     //   arrayAdapter.notifyDataSetChanged();
        return sinhVien;
    }
    /* Thêm dữ liệu vào cơ sở dữ liệu
     */
    public static Mydatabase database;
    public void them() {
        sinhvien sinhVien1 = layDuLieuNguoiDung();
        if (sinhVien1 != null) {
            if (database.Them(sinhVien1) != -1) {
              //  capNhatDuLieu();
            }
        }
    }

    public void capNhatDuLieu() {
     //   sinhVienArrayList.removeAll(sinhVienArrayList);
        // Lấy dữ liệu, dùng Cursor nhận lại
       Cursor cursor = database.LayTatCaDuLieu();
       // sinhvien sv =new sinhvien();
      //  Cursor cursor = database.Them(sinhvien sv);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                sinhvien sinhVien = new sinhvien();
                sinhVien.setId(Integer.parseInt(cursor.getString(0)));
                sinhVien.setTen(cursor.getString(1));
                sinhVien.setLop(cursor.getString(2));
                //them id,ten,lop o sinhvien vao arratlist muc dich de dua len listview
                sinhVienArrayList.add(sinhVien);

            }

        }
        arrayAdapter.notifyDataSetChanged();

    }

}
