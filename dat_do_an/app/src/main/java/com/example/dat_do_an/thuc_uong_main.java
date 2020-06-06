package com.example.dat_do_an;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class thuc_uong_main  extends AppCompatActivity {
    ListView lvthucuong;
    String [] tennuocuong={"coca","nước suối","bia","chanh muối"};
    int []anhthucuong={R.drawable.coca,R.drawable.nuocsuoi,R.drawable.bia,R.drawable.chanh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thucuong);
        setControl();
        setEvent();

    }
    public void setControl() {

        lvthucuong=findViewById(R.id.thucuongLv);
    }
    public void setEvent()
    {
        customadapter_thucuong adapter =new customadapter_thucuong(thuc_uong_main.this,R.layout.drink,tennuocuong,anhthucuong);
        lvthucuong.setAdapter(adapter);
        lvthucuong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(thuc_uong_main.this,MainActivity.class);
                intent1.putExtra("key_drink",tennuocuong[position]);
                startActivity(intent1);
            }
        });

    }
}
