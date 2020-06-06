package com.example.quanlibanhang;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class activity_nhanvien extends AppCompatActivity {
    EditText username,password, tennv, diachi, sdt;
    Spinner chucvunv;
    TextView maNVtv;
    Button ok,huy;
    database dbmh;
    ArrayList<Nhanvien> data = new ArrayList<Nhanvien>();
    ArrayList chucvu=new ArrayList();
    ImageView ibtnCamera, ibtnFolder;
    ImageView anh;
    int REQUEST_CODE_CAMERA=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);
        setControl();
        setEvent();
    }

    public void setControl()
    {
        maNVtv=findViewById(R.id.usernametv);
        username=findViewById(R.id.useret);
        password=findViewById(R.id.pass);
        tennv=findViewById(R.id.tenNVet);
        diachi=findViewById(R.id.diachinvet);
        sdt=findViewById(R.id.sdtNVet);
        chucvunv=findViewById(R.id.chucvuuet);
        ok=findViewById(R.id.okbtnv);
        huy=findViewById(R.id.huybtnv);
        anh=findViewById(R.id.anhnv);
        ibtnCamera=findViewById(R.id.chupanhnv);
        ibtnFolder=findViewById(R.id.chonanhnv);
    }

    public void setEvent()
    {
        chucvu.add("Quan li");
        chucvu.add("NVBH");
        chucvu.add("NVK");
        ArrayAdapter a=new ArrayAdapter(this,R.layout.layouttextview,chucvu);
        chucvunv.setAdapter(a);

        dbmh=new database(this);
        Intent intent =getIntent();
        final int vitri = intent.getIntExtra("vitriNV",0);

        int role=intent.getIntExtra("roleNV",-2);
        //nếu màn hình kia bấm nút sửa
        if (role==-1)
        {
            //lay du lieu tu database va gan vao mang data
            capNhatDuLieu();

            username.setText(data.get(vitri).getUsername());
            username.setEnabled(false);
            password.setText(data.get(vitri).getPass());
            tennv.setText(data.get(vitri).getTen());
            sdt.setText(data.get(vitri).getSdt());
            diachi.setText(data.get(vitri).getDiachi());
            anh.setImageBitmap(BitmapFactory.decodeByteArray(data.get(vitri).getHinhanh(),0,data.get(vitri).getHinhanh().length));

            //tenSpp.setSelection(data.indexOf(data.get(vitri).getTenspHD()));

            chucvunv.setSelection(data.indexOf(data.get(vitri).getChucvu()));
           // maKH.setEnabled(false);
            ok.setOnClickListener(new View.OnClickListener() {
                //click vào button ok thì dữ liêu lấy từ giao diện được lưu vào class
                @Override
                public void onClick(View v) {
                    Nhanvien kh=data.get(vitri);
                 //   kh.setUsername(username.getText().toString());
                    kh.setPass(password.getText().toString());
                    kh.setTen(tennv.getText().toString());
                    kh.setSdt(sdt.getText().toString());
                    kh.setDiachi(diachi.getText().toString());
                    kh.setHinhanh(ConverttoArrayByte(anh));
                   // hd.setTenspHD(tenSpp.getSelectedItem().toString());
                    kh.setChucvu(chucvunv.getSelectedItem().toString());
                    dbmh.suaNhanVien(kh);
                    Toast.makeText(getApplicationContext(), "Chỉnh sửa thành công", Toast.LENGTH_LONG).show();

                }
            });

        }

//nút thêm
        if(role!=-1) {
        //    maKH.setVisibility(View.INVISIBLE);
         //   maKHtv.setVisibility(View.INVISIBLE);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    if (username.getText().toString().equals("")) {
                        username.setError("ban phai nhap username cho nhan vien");
                        username.requestFocus();
                        return;
                    }
                    if (password.getText().toString().equals("")) {
                        password.setError("ban phai nhap password");
                        password.requestFocus();
                        return;
                    }
                    if (sdt.getText().toString().equals("")) {
                        sdt.setError("ban phai nhap sdt");
                        sdt.requestFocus();
                        return;
                    }
                    if (diachi.getText().toString().equals("")) {
                        diachi.setError("ban phai nhap dia chi");
                        diachi.requestFocus();
                        return;
                    }


                    Nhanvien kh = layDLTuGiaoDien();
                    dbmh.ThemNhanvien(kh);
                    Toast.makeText(getApplicationContext(), "Thêm nhan vien thành công", Toast.LENGTH_LONG).show();
                }

            });}
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_nhanvien.this, listview_nhanvien.class);
                startActivity(intent);
            }
        });

        ibtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//            //startActivityForResult(intent,REQUEST_CODE_CAMERA);
////            if (intent.resolveActivity(getPackageManager()) != null) {

////
////            }
                ActivityCompat.requestPermissions(activity_nhanvien.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);

            }
        });
        ibtnFolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        Intent intent =new Intent(Intent.ACTION_PICK);
//        intent.setType("image/*");
//        startActivityForResult(intent,REQUEST_CODE_FOLDER);
                //  ActivityCompat.requestPermissions(activity_mathang.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE_FOLDER);
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto , 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==REQUEST_CODE_CAMERA && grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,REQUEST_CODE_CAMERA);
        }

        else
        {
            Toast.makeText(this,"chưa cho phép mở mà đòi mở hả con ml", Toast.LENGTH_SHORT).show();

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode ==REQUEST_CODE_CAMERA && resultCode==RESULT_OK &&data!=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            anh.setImageBitmap(bitmap);
        }
        if(requestCode==1 && resultCode == RESULT_OK){
            Uri selectedImage = data.getData();
            anh.setImageURI(selectedImage);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    //    @Override
//    public void onRequestP
    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public Nhanvien layDLTuGiaoDien(){
        Nhanvien kh =new Nhanvien();
        kh.setUsername(username.getText().toString());
        kh.setPass(password.getText().toString());
        kh.setTen(tennv.getText().toString());
        kh.setSdt(sdt.getText().toString());
        kh.setDiachi(diachi.getText().toString());
        kh.setChucvu(chucvunv.getSelectedItem().toString());
        kh.setHinhanh(ConverttoArrayByte(anh));
       // kh.setChucvu(chucvunv.getText().toString());
        return kh;
    }


    public void capNhatDuLieu() {
        Cursor cursor = dbmh.LayTatCaDuLieuNhanVien();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Nhanvien kh =new Nhanvien();
                kh.setUsername( cursor.getString(0));
                kh.setPass(cursor.getString(1));
                kh.setTen(cursor.getString(2));
                kh.setSdt( cursor.getString(3));
                kh.setDiachi( cursor.getString(4));
                kh.setChucvu( cursor.getString(5));
                kh.setHinhanh(cursor.getBlob(6));
                data.add(kh);

            }

        }


    }
}
