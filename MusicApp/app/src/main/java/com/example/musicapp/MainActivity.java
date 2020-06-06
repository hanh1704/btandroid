package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String [] combobox={"banh xeo","banh cuon","banh bao","BBQ","hanh","hien","hihihi","banh da lon","banh bao","BBQ","hanh","hien","hihihi","banh da lon"};
    public ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicapp);

        setControl();
        setEvent();

    }
    public void setControl()
    {

        lv1=findViewById(R.id.lv);

    }
    public void setEvent()
    {

        ArrayAdapter <String> adapter=new ArrayAdapter <>(this,android.R.layout.simple_list_item_1,combobox);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"ban da chon "+combobox[position],Toast.LENGTH_LONG).show();

            }
        });

    }
}
