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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class activity_khachhang  extends AppCompatActivity {
    EditText maKH, tenKH, diachi, sdt;
    TextView maKHtv;
    Button ok,huy;
    database dbmh;
    ImageView ibtnCamera, ibtnFolder;
    ImageView anh;
    int REQUEST_CODE_CAMERA=123;
    ArrayList <KhachHang> data = new ArrayList<KhachHang>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khachhang);
        setControl();
        setEvent();
    }

    public void setControl()
    {
        maKH=findViewById(R.id.maKHEt);
        tenKH=findViewById(R.id.tenKHEt);
        diachi=findViewById(R.id.diachiet);
        sdt=findViewById(R.id.sdtet);
        ok=findViewById(R.id.okbtkh);
        huy=findViewById(R.id.huybtkh);
        maKHtv=findViewById(R.id.mahang_kh);
        anh=findViewById(R.id.anhkh);
        ibtnCamera=findViewById(R.id.chupanhkh);
        ibtnFolder=findViewById(R.id.chonanhkh);
    }

    public void setEvent()
    {
        dbmh=new database(this);
        Intent intent =getIntent();
        final int vitri = intent.getIntExtra("vitriKH",0);

        int role=intent.getIntExtra("roleKH",-2);
        //nếu màn hình kia bấm nút sửa
        if (role==-1)
        {
            //lay du lieu tu database va gan vao mang data
            capNhatDuLieu();

            tenKH.setText(data.get(vitri).getTenKH());
            diachi.setText(data.get(vitri).getDiaChi());
            sdt.setText(data.get(vitri).getSDT());
            maKH.setText(data.get(vitri).getMaKH());
            anh.setImageBitmap(BitmapFactory.decodeByteArray(data.get(vitri).getHinhanh(),0,data.get(vitri).getHinhanh().length));
            maKH.setEnabled(false);
            ok.setOnClickListener(new View.OnClickListener() {
                //click vào button ok thì dữ liêu lấy từ giao diện được lưu vào class
                @Override
                public void onClick(View v) {
                    KhachHang kh=data.get(vitri);
                    kh.setTenKH(tenKH.getText().toString());
                    kh.setDiaChi(diachi.getText().toString());
                    kh.setSDT(sdt.getText().toString());
                    kh.setHinhanh(ConverttoArrayByte(anh));
                    dbmh.suaKhachHang(kh);
                    Toast.makeText(getApplicationContext(), "Chỉnh sửa thành công", Toast.LENGTH_LONG).show();

                }
            });

        }

//nút thêm
        if(role!=-1) {
            maKH.setVisibility(View.INVISIBLE);
            maKHtv.setVisibility(View.INVISIBLE);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    if (tenKH.getText().toString().equals("")) {
                        tenKH.setError("ban phai nhap ten KH");
                        tenKH.requestFocus();
                        return;
                    }
                    if (diachi.getText().toString().equals("")) {
                        diachi.setError("ban phai nhap dia chi");
                        diachi.requestFocus();
                        return;
                    }
                    if (sdt.getText().toString().equals("")) {
                        sdt.setError("ban phai nhap sdt");
                        sdt.requestFocus();
                        return;
                    }

                    KhachHang kh = layDLTuGiaoDien();
                    dbmh.ThemKhachHang(kh);
                    Toast.makeText(getApplicationContext(), "Thêm khách hàng thành công", Toast.LENGTH_LONG).show();
                }

            });}
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_khachhang.this, listview_khachhang.class);
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
                ActivityCompat.requestPermissions(activity_khachhang.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);

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



    public KhachHang layDLTuGiaoDien(){
        KhachHang kh =new KhachHang();
        kh.setTenKH(tenKH.getText().toString());
        kh.setDiaChi(diachi.getText().toString());
        kh.setSDT(sdt.getText().toString());
        kh.setHinhanh(ConverttoArrayByte(anh));
        return kh;
    }
    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }


    public void capNhatDuLieu() {
        Cursor cursor = dbmh.LayTatCaDuLieuKhachHang();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                KhachHang kh =new KhachHang();
                kh.setMaKH("" + cursor.getInt(0));
                kh.setTenKH(cursor.getString(1));
                kh.setDiaChi(cursor.getString(2));
                kh.setSDT( cursor.getString(3));
                kh.setHinhanh(cursor.getBlob(4));
                data.add(kh);

            }

        }


    }
}
