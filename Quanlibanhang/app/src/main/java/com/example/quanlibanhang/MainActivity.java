package com.example.quanlibanhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button Dangnhap;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    public void setControl() {
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        Dangnhap = findViewById(R.id.dn);
    }

    public void setEvent() {
        db = new database(this);


        Dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, menu.class);
//                //intent.putExtra("role", "nvk");
//                startActivity(intent);
                int i=0;
                String role="";

                Cursor cursor =db.CheckLogin(user.getText().toString(), pass.getText().toString());
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        Nhanvien nv =new Nhanvien();

                        nv.setChucvu(cursor.getString(5));
                        role=nv.getChucvu();
                        i++;

                    }
                }

                if(i==1 ) {
                    Intent intent = new Intent(MainActivity.this, menu.class);

                    startActivity(intent);
                }
//                if(i==1 && role.equals("Nhan vien ban hang")==true) {
//                    Intent intent = new Intent(MainActivity.this, menu.class);
//                    intent.putExtra("role","nvbh");
//                    startActivity(intent);
//                }
//                if(i==1 && role.equals("Nhan vien kho")==true) {
//                    Intent intent = new Intent(MainActivity.this, menu.class);
//                    intent.putExtra("role","nvk");
//                    startActivity(intent);
//                }
                if(i==0)
                {
                    Toast.makeText(getApplicationContext(), "Thông tin tài khoản sai, mời nhập lại", Toast.LENGTH_LONG).show();
                   // user.clearFocus();
                  //  pass.clearFocus();

                }
            }
        });

//    public Nhanvien layDL
//    }TuGiaoDien(){
//        Nhanvien nv =new Nhanvien();
//        nv.setUsername(user);
//        kh.setTenKH(tenKH.getText().toString());
//        kh.setDiaChi(diachi.getText().toString());
//        kh.setSDT(sdt.getText().toString());
//        return kh;
//    }
    }
}
