package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class listview_hoadon extends AppCompatActivity {
    ListView listHD;
    Button addbt,editbt,deletebt,exitbt;
    database dataHoaDon;
    int vitri=-1;
    ArrayList<HoaDon> data = new ArrayList<HoaDon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_hoadon);
        setControl();
       setEvent();

    }
    public void setControl()
    {
        listHD=findViewById(R.id.hoadon_listview);
        addbt=findViewById(R.id.addHD);
        editbt=findViewById(R.id.editHD);
        deletebt=findViewById(R.id.deleteHD);
        exitbt=findViewById(R.id.exitHD);
    }
    public void setEvent()
    {
        //load data len listview bằng adapter
        final HoaDonAdapter adapterhoadon=new HoaDonAdapter(this,R.layout.item_hoadon,data);
        dataHoaDon = new database(this);
        listHD.setAdapter(adapterhoadon);

        //Lấy toàn bộ dữ liệu gán vào data
        Cursor cursor = dataHoaDon.LayTatCaDuLieuHoaDon();
        if (cursor != null) {
            data.clear();
            while (cursor.moveToNext()) {
                HoaDon hd = new HoaDon();
                hd.setSoHD("" + cursor.getInt(0));
                hd.setNgayLap(cursor.getString(1));
                hd.setMakhHD(cursor.getString(2));
                hd.setTenspHD(cursor.getString(3));
                hd.setSoluongHD("" + cursor.getInt(4));
                hd.setThanhtienHD("" + cursor.getInt(5));
                data.add(hd);
            }
            adapterhoadon.notifyDataSetChanged();
        }
       //Chọn 1 item trong listview
        listHD.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                vitri=position;
//                for (int i = 0; i < listHD.getChildCount(); i++) {
//                    if(position == i ){
//
//                        listHD.getChildAt(i).setBackgroundColor(Color.rgb(110,145,191));
//                    }else{
//                        listHD.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
//                    }
//                }

            }
        });
        //Chỉnh sửa 1 item trong listview, gửi 1 vitri của item sang activity tiếp theo, gán rolehd=1, để biết lệnh này để chỉnh sửa
        editbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(listview_hoadon.this,activity_hoadon.class);
                intent.putExtra("vitriHD",vitri);
                intent.putExtra("roleHD",-1);
                startActivity(intent);
            }
        });

        //Thêm 1 item
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(listview_hoadon.this,activity_hoadon.class);
                startActivity(intentt);
            }
        });

        //delete 1 item
        deletebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoaDon hd=data.get(vitri);
                dataHoaDon.XoaHoaDon(hd);
                data.remove(vitri);
                adapterhoadon.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_LONG).show();

            }
        });
        //Thoát khỏi danh sách hóa đơn để trở về màn hình menu chính
        exitbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(listview_hoadon.this, menu.class);
                startActivity(intent);
            }
        });

    }
}