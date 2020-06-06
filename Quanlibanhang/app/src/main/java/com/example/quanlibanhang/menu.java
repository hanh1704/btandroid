package com.example.quanlibanhang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity {
      ImageView khImage,spImage,hdImage,nvImage,tkImage,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
         setControl();
        setEvent();
    }
    public void setControl()
    {
        khImage=findViewById(R.id.imageKH);
        spImage=findViewById(R.id.imageSP);
        hdImage=findViewById(R.id.imageHD);
        nvImage=findViewById(R.id.imageNhanVien);
        tkImage=findViewById(R.id.thongke);
        logout=findViewById(R.id.logout);
    }
    public void setEvent()
    {
//        Intent intent =getIntent();
//         String role = intent.getStringExtra("role");
//        int rolee=intent.getIntExtra("roleKHH",-2);

      //  Toast.makeText(getApplicationContext(),rolee,Toast.LENGTH_LONG).show();
//         if(role.equals("nvbh")==true || rolee==2)
//         {
//             spImage.setEnabled(false);
//             nvImage.setEnabled(false);
//         }
//        if(role.equals("nvk")==true)
//        {
//            khImage.setEnabled(false);
//            hdImage.setEnabled(false);
//            nvImage.setEnabled(false);
//        }

       // int role=intent.getIntExtra("roleKH",-2);
        khImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,listview_khachhang.class);
               // intent.putExtra("role","nvbh");
                startActivity(intent);

            }
        });
        spImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,listview_sanpham.class);
                startActivity(intent);
            }
        });
        hdImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,listview_hoadon.class);
                startActivity(intent);
            }
        });
        nvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,listview_nhanvien.class);
                startActivity(intent);
            }
        });
        tkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,menuthongke.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
