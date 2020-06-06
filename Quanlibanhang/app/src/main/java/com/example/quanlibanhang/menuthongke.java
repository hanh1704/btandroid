package com.example.quanlibanhang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class menuthongke extends AppCompatActivity {
    ListView menu;
    Button exit;
    ArrayList data =new ArrayList();
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuthongke);
        setControl();
        setEvent();


    }
    public void setControl(){
        menu=findViewById(R.id.menutk);
        exit=findViewById(R.id.exittkmenu);
    }
    public void setEvent(){
        data.add("THỐNG KÊ DS ");
        data.add("TK HÀNG BÁN CHẠY ");
        data.add("TK DOANH SỐ KH");
        ArrayAdapter a=new ArrayAdapter<>(this,R.layout.layouttextview,data);
        menu.setAdapter(a);
        menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0) {
                    Intent intent = new Intent(menuthongke.this, doanhsothang.class);
                    startActivity(intent);
                }
                if (position==1) {
                    Intent intent = new Intent(menuthongke.this, tkhangbanchay.class);
                    startActivity(intent);
                }
                if (position==2)
                {
                    Intent intent = new Intent(menuthongke.this, dskhachang.class);
                    startActivity(intent);
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(menuthongke.this, com.example.quanlibanhang.menu.class);
                startActivity(inten);
            }
        });
    }
}
