package com.example.baithuchanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
 public EditText a,b,ketqua;
public Button cong,tru,nhan,chia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }
    public void setControl()
    {
        a=(EditText)findViewById(R.id.edita);
        b=(EditText)findViewById(R.id.editb);
        ketqua=(EditText)findViewById(R.id.resultedit);
        cong=(Button)findViewById(R.id.buttonCong);
        tru=(Button)findViewById(R.id.buttonTru);
        nhan=(Button)findViewById(R.id.buttonNhan);
        chia=(Button)findViewById(R.id.buttonChia);
    }
    public void setEvent(){
//        soa=Integer.parseInt(ra.toSting());
//        System.out.println(soa);
//        sob=Integer.parseInt(b.toString());

        cong.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String chuoi1=a.getText().toString();
                int soA=Integer.parseInt(chuoi1);
                String chuoi2=b.getText().toString();
                int soB=Integer.parseInt(chuoi2);
                int kq=soA+soB;
                ketqua.setText(String.valueOf(kq));
              //  System.out.println(kq);
            }
        });

        tru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String chuoi1=a.getText().toString();
                int soA=Integer.parseInt(chuoi1);
                String chuoi2=b.getText().toString();
                int soB=Integer.parseInt(chuoi2);
                int kq=soA-soB;
                ketqua.setText(String.valueOf(kq));
            }
        });
        nhan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
              String chuoi1=a.getText().toString();
                int soA=Integer.parseInt(chuoi1);
                String chuoi2=b.getText().toString();
                int soB=Integer.parseInt(chuoi2);
                int kq=soA*soB;
                ketqua.setText(String.valueOf(kq));
            }
        });
        chia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String chuoi1=a.getText().toString();
                int soA=Integer.parseInt(chuoi1);
                String chuoi2=b.getText().toString();
                int soB=Integer.parseInt(chuoi2);
                int kq=soA/soB;
                ketqua.setText(String.valueOf(kq));
            }
        });
    }
}
