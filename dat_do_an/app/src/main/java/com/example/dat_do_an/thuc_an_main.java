package com.example.dat_do_an;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class thuc_an_main extends AppCompatActivity {
    ListView lvthucan;
    String [] tenmonan={"bún bò","cháo","bánh canh","phở"};
    int [] anhmonan={R.drawable.bunbo,R.drawable.chao,R.drawable.banhcanh,R.drawable.pho};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thucan);
        setControl();
        setEvent();

    }
    public void setControl() {

        lvthucan = findViewById(R.id.thucanLv);
    }
    public void setEvent()
    {

        customadapter_thucan adapter =new customadapter_thucan(thuc_an_main.this,R.layout.food,tenmonan,anhmonan);
        lvthucan.setAdapter(adapter);
        lvthucan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(thuc_an_main.this,MainActivity.class);
                intent1.putExtra("key_food",tenmonan[position]);
                startActivity(intent1);
            }
        });


    }
}
