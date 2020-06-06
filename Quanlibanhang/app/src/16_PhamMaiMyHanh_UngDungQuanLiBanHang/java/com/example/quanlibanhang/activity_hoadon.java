package com.example.quanlibanhang;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class activity_hoadon extends AppCompatActivity {
    EditText maHD, ngayLap, soluong, thanhtien;
    EditText gia;
    Spinner maKHlap, tenSpp;
    TextView titlemahd;
    Button ok, huy;
    database dbmh;
    ArrayList<KhachHang> listMaKH = new ArrayList<KhachHang>();
    ArrayList<MatHang> listSPP = new ArrayList<MatHang>();
    ArrayList<HoaDon> data = new ArrayList<HoaDon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);
        setControl();
        setEvent();
    }

    public void setControl() {
        maHD = findViewById(R.id.mahdet);
        ngayLap = findViewById(R.id.ngalapet);
        maKHlap = findViewById(R.id.makh_hdsp);
        tenSpp = findViewById(R.id.tenspHDet);
        soluong = findViewById(R.id.soluongHDet);
        thanhtien = findViewById(R.id.Thanhtienhdet);
        ok = findViewById(R.id.okbthd);
        huy = findViewById(R.id.huybthd);
        titlemahd = findViewById(R.id.mahoadontv);
        gia=findViewById(R.id.gia);

    }

    public void setEvent() {
        dbmh = new database(this);
        //Lấy toàn bộ dữ liệu ở bảng khách hàng
        //set giá trị mã khách hàng vào mảng data
        Cursor cursor = dbmh.LayTatCaDuLieuKhachHang();
        if (cursor != null) {
            listMaKH.clear();
            while (cursor.moveToNext()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH("" + cursor.getInt(0));
                listMaKH.add(kh);
            }
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.layouttextview, listMaKH);
            maKHlap.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
            Cursor cursor2 = dbmh.LayTatCaDuLieuMatHang();
            if (cursor2 != null) {
                listSPP.clear();
                while (cursor2.moveToNext()) {
                    MatHang mh = new MatHang();
                    mh.setMaHang(""+cursor2.getInt(0));
                    mh.setTenHang(cursor2.getString(1));

                    listSPP.add(mh);
                }
                ArrayAdapter adapter1 = new ArrayAdapter(this, R.layout.layouttextview, listSPP);
                tenSpp.setAdapter(adapter1);
                adapter1.notifyDataSetChanged();
            }


                //load data lên listview bằng adapter

                tenSpp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    String b[] = tenSpp.getSelectedItem().toString().split("-");
                                    String cd[] =new String[2];
                                    for (int i=0;i<2;i++) {
                                        cd[i]=b[i];
                                    }
                                        Cursor c = dbmh.layGia(cd[0]);
                                    String k;
                                    if (c != null) {

                                        while (c.moveToNext()) {
                                            MatHang kh = new MatHang();
                                kh.setGiaHang(c.getString(3));

                                gia.setText(kh.getGiaHang());
                                        }
                                    }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



            //Nhận giá trị của vị trí với quyền sửa item
            Intent intent = getIntent();
            final int vitri = intent.getIntExtra("vitriHD", 0);
            int role = intent.getIntExtra("roleHD", -2);
            if (role == -1) {
                //lay du lieu tu database va gan vao mang data
                capNhatDuLieu();
                //set gia trị tại vị trí position lên lại giao diện để chỉnh sửa
                maHD.setText(data.get(vitri).getSoHD());
                ngayLap.setText(data.get(vitri).getNgayLap());
                maKHlap.setSelection(data.indexOf(data.get(vitri).getMakhHD()));
                tenSpp.setSelection(data.indexOf(data.get(vitri).getTenspHD()));
                soluong.setText(data.get(vitri).getSoluongHD());
                thanhtien.setText(data.get(vitri).getThanhtienHD());
                maHD.setEnabled(false);
                //sau khi bấm nút ok thì set lại giá trị tại vị trí vitri
                ok.setOnClickListener(new View.OnClickListener() {
                    //click vào button ok thì dữ liêu lấy từ giao diện được lưu vào class
                    @Override
                    public void onClick(View v) {

                        HoaDon hd = data.get(vitri);
                        hd.setNgayLap(ngayLap.getText().toString());
                        hd.setMakhHD(maKHlap.getSelectedItem().toString());
                        hd.setTenspHD(tenSpp.getSelectedItem().toString());
                        hd.setSoluongHD(soluong.getText().toString());
                        //hd.setThanhtienHD(thanhtien.getText().toString());
                        int a=Integer.parseInt(gia.getText().toString());
                        int b=Integer.parseInt(soluong.getText().toString());
                        int c=a*b;
                        thanhtien.setText(Integer.toString(c));
                        hd.setThanhtienHD(thanhtien.getText().toString());

                        //update gia tri vao database
                        dbmh.suaHoaDon(hd);
                        Toast.makeText(getApplicationContext(), "Chỉnh sửa thành công", Toast.LENGTH_LONG).show();
                    }
                });



            }

//nút thêm
            if (role != -1) {
               DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String date = df.format(Calendar.getInstance().getTime());
                ngayLap.setText(date);
                maHD.setVisibility(View.INVISIBLE);
                titlemahd.setVisibility(View.INVISIBLE);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int a=Integer.parseInt(gia.getText().toString());
                        int b=Integer.parseInt(soluong.getText().toString());
                        int c=a*b;
                        thanhtien.setText(Integer.toString(c));

//                        if (ngayLap.getText().toString().equals("")) {
//                            ngayLap.setError("ban phai nhap ngay lap");
//                            ngayLap.requestFocus();
//                            return;
//                        }

                        if (soluong.getText().toString().equals("")) {
                            soluong.setError("ban phai nhap so luong");
                            soluong.requestFocus();
                            return;
                        }


                        HoaDon hd = layDLTuGiaoDien();
                        dbmh.ThemHoaDON(hd);
                        Toast.makeText(getApplicationContext(), "Thêm hóa đơn thành công", Toast.LENGTH_LONG).show();
                    }

                });

            }
            huy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity_hoadon.this, listview_hoadon.class);
                    startActivity(intent);
                }
            });



    }
        public HoaDon layDLTuGiaoDien () {

            HoaDon hd = new HoaDon();
            hd.setNgayLap(ngayLap.getText().toString());
            hd.setMakhHD(maKHlap.getSelectedItem().toString());
            hd.setTenspHD(tenSpp.getSelectedItem().toString());
            hd.setSoluongHD(soluong.getText().toString());
            hd.setThanhtienHD(thanhtien.getText().toString());
                return hd;

        }


        public void capNhatDuLieu () {
            Cursor cursor = dbmh.LayTatCaDuLieuHoaDon();
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

        }


    }


