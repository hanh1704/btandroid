package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class doanhsothang extends AppCompatActivity {
    EditText thang, nam;
    Button tk,exit;
    TextView kq;
    database db;
  //     int tong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsthang);
        setControl();
        setEvent();

    }
    public void setControl()
    {

        nam=findViewById(R.id.nam);
        tk=findViewById(R.id.thongkee);
        kq=findViewById(R.id.kqtk);
        exit=findViewById(R.id.exittk);
    }
    public void setEvent(){
        db=new database(this);
        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        int tong=0;
               // Toast.makeText(getApplicationContext(),"coo",Toast.LENGTH_LONG).show();
               Cursor cursor = db.CheckDS(nam.getText().toString());
               // Toast.makeText(getApplicationContext(),nam.getText().toString(),Toast.LENGTH_LONG).show();
                if (cursor != null) {
                   // Toast.makeText(getApplicationContext(),"co",Toast.LENGTH_LONG).show();
                    HoaDon hd = new HoaDon();
                    while (cursor.moveToNext()) {

                        hd.setThanhtienHD("" + cursor.getInt(5));
                        tong += Integer.parseInt(hd.getThanhtienHD());


                    }
                    String t=String.valueOf(tong);
                   // Toast.makeText(getApplicationContext(),t,Toast.LENGTH_LONG).show();

                    kq.setText(t);

               }


                if(cursor==null) {
                    Toast.makeText(getApplicationContext(), " k co", Toast.LENGTH_LONG).show();
                }
            }

        });
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(doanhsothang.this,menuthongke.class);
        startActivity(intent);
    }
});

}
}
