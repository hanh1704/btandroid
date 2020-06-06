package com.example.dat_do_an;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btThemthucan;
    Button btThemthucuong;
    Button btthoat;
    public TextView ketqua;
    String kq = "";
    String mang []=new String [2];

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setControl();
        setEvent();
        hihi();
    }

    public void setControl() {
        btThemthucan = findViewById(R.id.food);
        btThemthucuong = findViewById(R.id.drink);
        ketqua = findViewById(R.id.hienthi);
    }

    public void setEvent() {

        btThemthucan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), thuc_an_main.class);
                startActivity(intent);
            }
        });
        btThemthucuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), thuc_uong_main.class);
                startActivity(intent);

            }
        });

    }
    public void hihi ()
    {
        Intent intentt = getIntent();
        if (intentt.getStringExtra("key_food") != null) {
            prefs.edit().putString("key_food", intentt.getStringExtra("key_food").toString()).commit();


        }
        if (intentt.getStringExtra("key_drink") != null) {
            prefs.edit().putString("key_drink", intentt.getStringExtra("key_drink").toString()).commit();

        }

        ketqua.setText(prefs.getString("key_food","")+ "  "+prefs.getString("key_drink",""));



    }
}

