package com.example.appp;

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
//    private Switch sw1,sw2;
//    private Button submitbt;
 //   public Spinner spinerr1;
    public String [] combobox={"banh xeo","banh cuon","banh bao","BBQ","hanh","hien","hihihi","banh da lon","banh bao","BBQ","hanh","hien","hihihi","banh da lon"};
    public ListView lv1;
//    public String [] combobox={"banh xeo","banh cuon","banh bao","BBQ"};
//    public ListView listcus;
// //   public String [] combobox={"banh xeo","banh cuon","banh bao","BBQ"};
//    int [] flag={R.drawable.download,R.drawable.bbq};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.listview);
     ////   Log.d("test","hien thi message");
        setControl();
        setEvent();

    }
    public void setControl()
    {
//            spinerr1=findViewById(R.id.spinner);
//        sw1=findViewById(R.id.switch1);
//        sw2=findViewById(R.id.switch2);
//        submitbt=findViewById(R.id.submitbt);
        lv1=findViewById(R.id.lv);
    //    listcus=findViewById(R.id.listcustom);
    }
    public void setEvent()
    {
//        //đổ dữ liệu vào
//        ArrayAdapter <String> adapter=new ArrayAdapter <>(this,android.R.layout.simple_spinner_item,combobox);
//        spinerr1.setAdapter(adapter);
//        spinerr1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            //chọn item nào?
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"ban da chon "+combobox[position],Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(getApplicationContext(),"ban khong chon ",Toast.LENGTH_LONG).show();
//
//            }
//        });
                ArrayAdapter <String> adapter=new ArrayAdapter <>(this,android.R.layout.simple_list_item_1,combobox);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"ban da chon "+combobox[position],Toast.LENGTH_LONG).show();

            }
        });
//        ArrayAdapter <String> adapter=new ArrayAdapter <>(this,android.R.layout.simple_list_item_1,combobox);
//        listcus.setAdapter(adapter);
//        listcus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),"ban da chon "+combobox[position],Toast.LENGTH_LONG).show();
//
//            }
//        });
//        submitbt.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v)
//            {
//                String statusSwitch1, statusSwitch2;
//                if (sw1.isChecked())
//                {
//                    statusSwitch1=sw1.setText("switch 1 được chọn");
//                    Toast.makeText(getApplicationContext(),statusSwitch1,Toast.LENGTH_LONG).show();
//                }
//                if (sw2.isChecked())
//                {
//                    statusSwitch2=sw2.setText("switch 1 được chọn");
//                    Toast.makeText(getApplicationContext(),statusSwitch2,Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });
    }
}
