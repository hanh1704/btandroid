package com.example.time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
//    TimePicker dongho;
//    TextView timee;

    EditText sophieu;
    EditText ngayMuon;
    EditText ghiChu;
    Spinner docGia;
    Spinner Sach;
    Button add;
    Button edit;
    Button delete;
    Button exit;
    ListView danhSach;
    ArrayList <String> tendocgia=new ArrayList<>();
    ArrayList <String> tenSach=new ArrayList<>();

    int vitri=-1;
    ArrayList <phieumuon> data = new ArrayList<phieumuon>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        tendocgia.add("hanh");
        tenSach.add("book");
//        dongho=findViewById(R.id.clock);
//        timee=findViewById(R.id.text1);

        sophieu=findViewById(R.id.sophieu);
        ngayMuon=findViewById(R.id.ngaymuon);
        ghiChu=findViewById(R.id.ghichu);
        docGia=findViewById(R.id.docgia);
        Sach=findViewById(R.id.sach);
        add=findViewById(R.id.them);
        edit=findViewById(R.id.sua);
        delete=findViewById(R.id.xoa);
        exit=findViewById(R.id.thoat);
       danhSach =findViewById(R.id.list);

    }
    public void setEvent ()
    {
//        dongho.setIs24HourView(false);
//        dongho.setOnTimeChangedListener(
//                new TimePicker.OnTimeChangedListener() {
//                    @Override
//                    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                        Toast.makeText(getApplicationContext(),hourOfDay+" "+minute,Toast.LENGTH_SHORT).show();
//                        timee.setText("Time is:: "+hourOfDay+":"+minute);
//                    }
//                }
//        );


        ArrayAdapter <String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tendocgia);
        docGia.setAdapter(adapter);
        ArrayAdapter <String> adapter2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,tenSach);
        Sach.setAdapter(adapter2);
        final phieumuonAdapter adapter3=new phieumuonAdapter(this,R.layout.dong_phieu_muon,data);
       // final ArrayAdapter <phieumuon> adapter3=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        danhSach.setAdapter(adapter3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sophieu.getText().toString().equals(""))
                {
                    sophieu.setError("ban phai nhap so phieu");
                    sophieu.requestFocus();
                    return;
                }
                if (ngayMuon.getText().toString().equals(""))
                {
                    ngayMuon.setError("ban phai nhap ngay");
                    ngayMuon.requestFocus();
                    return;
                }
           //     String data1=sophieu.getText().toString()+","+ngayMuon.getText().toString();
                phieumuon pm= new phieumuon();
                        //data.get(vitri) ;
                pm.setSophieumuon(sophieu.getText().toString());
                pm.setNgaymuon(ngayMuon.getText().toString());
                pm.setGhichu(ghiChu.getText().toString());
                pm.setDocgia(docGia.getSelectedItem().toString());
                pm.setTensach(Sach.getSelectedItem().toString());
                data.add(pm);

                adapter3.notifyDataSetChanged();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phieumuon pm= data.get(vitri);

                pm.setSophieumuon(sophieu.getText().toString());
                pm.setNgaymuon(ngayMuon.getText().toString());
                pm.setGhichu(ghiChu.getText().toString());
                pm.setDocgia(docGia.getSelectedItem().toString());
                pm.setTensach(Sach.getSelectedItem().toString());


                adapter3.notifyDataSetChanged();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(vitri);
                adapter3.notifyDataSetChanged();
            }
        });
        danhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri=position;
                sophieu.setText(data.get(position).getSophieumuon());
                ngayMuon.setText(data.get(position).getNgaymuon());
                ghiChu.setText(data.get(position).getGhichu());
                docGia.setSelection(tendocgia.indexOf(data.get(position).getDocgia()));
                Sach.setSelection(tenSach.indexOf(data.get(position).getTensach()));
            }
        });

        danhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data.remove(position);
                adapter3.notifyDataSetChanged();
                return false;

            }
        });

    }
}
