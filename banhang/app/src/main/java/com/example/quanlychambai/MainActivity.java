package com.example.quanlychambai;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText edtngaydat, edtsoluong;
    Spinner spKhachhang, spSanpham;
    Button btnThem, btnSua, btnXoa, btnThoat, btnHienThi, btnDanhSach;
    ListView lv;
    ArrayList<DatHangSanPham> data = new ArrayList<>();
    DatHangSanPhamdb dhspdb;
    ArrayList arrkhachhang = new ArrayList();
    ArrayList arrsanpham=  new ArrayList();
    int vitri=-1;
    //ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
public static DatHangSanPhamdb database;
    public void setEvent() {
        DateFormat df = new SimpleDateFormat("dd / MM / yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        edtngaydat.setText(date);
        arrkhachhang.add("Nguyen Van A");
        arrkhachhang.add("Nguyen Van B");
        arrsanpham.add("Bánh");
        arrsanpham.add("Kẹo");
        arrsanpham.add("Nước");
        dhspdb = new DatHangSanPhamdb(this);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrsanpham);
        spSanpham.setAdapter(adapter);
        ArrayAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrkhachhang);
        spKhachhang.setAdapter(adapter1);
        final dathangAdapter a =new dathangAdapter(this,R.layout.item_listview,data);
        lv.setAdapter(a);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(edtngaydat.getText().toString().equals(""))
                    {
                        edtngaydat.setError("Bạn phải nhập vào ngày đặt hàng");
                        edtngaydat.requestFocus();
                        return;
                    }
                    if(edtsoluong.getText().toString().equals("")) {
                        edtsoluong.setError("Bạn phải nhập vào số lượng");
                        edtsoluong.requestFocus();
                        return;
                    }
                DatHangSanPham dh = layDL();
                dhspdb.them(dh);
                Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_LONG).show();
            }
        });
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dhspdb.layTatCaDuLieu();
                if(cursor != null){
                    data.clear();
                    while (cursor.moveToNext()){
                        DatHangSanPham cb = new DatHangSanPham();
                        cb.setId("" + cursor.getInt(0));
                        cb.setNgaydat("" + cursor.getString(1));
                        cb.setSoluong("" + cursor.getString(2));
                        cb.setSanpham("" + cursor.getString(3));
                        cb.setKhachhang("" + cursor.getString(4));
                        data.add(cb);
                    }
                    a.notifyDataSetChanged();
                }
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vitri=position;
                for (int i = 0; i < lv.getChildCount(); i++) {
                    if(position == i ){

                        lv.getChildAt(i).setBackgroundColor(Color.rgb(204,240,244));
                    }else{
                        lv.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                edtngaydat.setText( data.get(position).getNgaydat());
                edtsoluong.setText(data.get(position).getSoluong());
                spKhachhang.setSelection(arrkhachhang.indexOf(data.get(position).getKhachhang()));
                spSanpham.setSelection(arrsanpham.indexOf(data.get(position).getSanpham()));


            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtngaydat.getText().toString().equals(""))
                {
                    edtngaydat.setError("Bạn phải nhập vào ngày đặt hàng");
                    edtngaydat.requestFocus();
                    return;
                }
                if(edtsoluong.getText().toString().equals("")) {
                    edtsoluong.setError("Bạn phải nhập vào số lượng");
                    edtsoluong.requestFocus();
                    return;
                }
                DatHangSanPham dh= data.get(vitri);
                dh.setNgaydat(edtngaydat.getText().toString());
                dh.setSoluong(edtsoluong.getText().toString());
                dh.setKhachhang(spKhachhang.getSelectedItem().toString());
                dh.setSanpham(spSanpham.getSelectedItem().toString());
                a.notifyDataSetChanged();
                dhspdb.sua(dh);
                Toast.makeText(getApplicationContext(), "Chỉnh thành công", Toast.LENGTH_LONG).show();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatHangSanPham dh= data.get(vitri);
                dhspdb.xoa(dh);
                data.remove(vitri);
                a.notifyDataSetChanged();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//lay du lieu tren giao dien gan vao class
    private DatHangSanPham layDL() {
        DatHangSanPham dh = new DatHangSanPham();
        dh.setNgaydat(edtngaydat.getText().toString());
        dh.setSoluong(edtsoluong.getText().toString());
        dh.setKhachhang(spKhachhang.getSelectedItem().toString());
        dh.setSanpham(spSanpham.getSelectedItem().toString());
        return dh;
    }

    public void setControl() {
        edtngaydat = findViewById(R.id.edtngaydat);
        edtsoluong= findViewById(R.id.edtsoluong);

        spSanpham = findViewById(R.id.spsanpham);
        spKhachhang = findViewById(R.id.spkhachhang);
        btnThem = findViewById(R.id.btnthem);
        btnSua = findViewById(R.id.btnsua);
        btnXoa = findViewById(R.id.btnxoa);
        btnThoat = findViewById(R.id.btnthoat);
        btnHienThi = findViewById(R.id.btnhienthi);

        lv = findViewById(R.id.listview);
    }
}
