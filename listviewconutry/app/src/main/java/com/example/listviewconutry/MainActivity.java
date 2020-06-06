package com.example.listviewconutry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String country[] = {"Việt Nam", "Mĩ", "Rumani"};
    int flag[] = {R.drawable.vn, R.drawable.us, R.drawable.ru};
    int popu[] = {90000000, 100000000, 800000000};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    public void setControl() {
        lv = findViewById(R.id.listview);
    }

    public void setEvent() {
        custom_list_adapter adapter = new custom_list_adapter(this,R.layout.item_country_in_listview,country,flag, popu);
        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,"Bạn chọn"+country[position],Toast.LENGTH_SHORT).show();
//            }
//        });
    }




}