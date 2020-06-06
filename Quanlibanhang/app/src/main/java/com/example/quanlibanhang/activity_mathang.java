package com.example.quanlibanhang;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class activity_mathang extends AppCompatActivity {
    EditText maHang,tenHang,donviHang, giaHang, soluongHang;
    TextView titlemaHang;
    Button ok,huy;
    database dbmh;
    ImageView ibtnCamera, ibtnFolder;
    ImageView anh;
    ArrayList <MatHang> data = new ArrayList<MatHang>();
    int REQUEST_CODE_CAMERA=123;
    int REQUEST_CODE_FOLDER=123456;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh);
        setControl();
        setEvent();
    }


    public void setControl()
    {
        maHang=findViewById(R.id.mahangEt);
      //  titlemaHang=findViewById(R.id.mahang_tv);
        tenHang=findViewById(R.id.tenhangEt);
        donviHang=findViewById(R.id.donviEt);
        giaHang=findViewById(R.id.giaEt);
        soluongHang=findViewById(R.id.soluongEd);
        ok=findViewById(R.id.okbt);
        huy=findViewById(R.id.huybt);
        ibtnCamera=findViewById(R.id.chupanh);
        ibtnFolder=findViewById(R.id.themanh);
        anh=findViewById(R.id.anh);
    }

    public void setEvent()
    {
        dbmh=new database(this);
        Intent intent =getIntent();
        final int vitri = intent.getIntExtra("vitri",0);
        int role=intent.getIntExtra("role",-2);
        //nếu màn hình kia bấm nút sửa
        if (role==-1)
        {
            //lay du lieu tu database va gan vao mang data
            capNhatDuLieu();

        tenHang.setText(data.get(vitri).getTenHang());
        donviHang.setText(data.get(vitri).getDonviHang());
        giaHang.setText(data.get(vitri).getGiaHang());
        soluongHang.setText(data.get(vitri).getSoluongHang());
        maHang.setText(data.get(vitri).getMaHang());
        anh.setImageBitmap(BitmapFactory.decodeByteArray(data.get(vitri).getHinhanh(),0,data.get(vitri).getHinhanh().length));
        maHang.setEnabled(false);
        ok.setOnClickListener(new View.OnClickListener() {
            //click vào button ok thì dữ liêu lấy từ giao diện được lưu vào class
            @Override
            public void onClick(View v) {
                MatHang mh=data.get(vitri);
                mh.setTenHang(tenHang.getText().toString());
                mh.setDonviHang(donviHang.getText().toString());
                mh.setGiaHang(giaHang.getText().toString());
                mh.setSoluongHang(soluongHang.getText().toString());
                mh.setHinhanh(ConverttoArrayByte(anh));
                dbmh.suaMatHang(mh);
                Toast.makeText(getApplicationContext(), "Chỉnh sửa thành công", Toast.LENGTH_LONG).show();

            }
        });

        }

//nút thêm
if(role!=-1) {
    maHang.setVisibility(View.INVISIBLE);
 //   titlemaHang.setVisibility(View.INVISIBLE);
    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tenHang.getText().toString().equals("")) {
                tenHang.setError("ban phai nhap ten hang");
                tenHang.requestFocus();
                return;
            }
            if (donviHang.getText().toString().equals("")) {
                donviHang.setError("ban phai nhap don vi hang");
                donviHang.requestFocus();
                return;
            }
            if (giaHang.getText().toString().equals("")) {
                giaHang.setError("ban phai nhap gia hang");
                giaHang.requestFocus();
                return;
            }
            if (soluongHang.getText().toString().equals("")) {
                soluongHang.setError("ban phai nhap so luong hang");
                soluongHang.requestFocus();
                return;
            }
            MatHang mh = layDLTuGiaoDien();
            dbmh.ThemMatHang(mh);

            Toast.makeText(getApplicationContext(), "Thêm hàng thành công", Toast.LENGTH_LONG).show();
        }

    });
}
    huy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity_mathang.this, listview_sanpham.class);
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
            ActivityCompat.requestPermissions(activity_mathang.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE_CAMERA);

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
       if (requestCode==REQUEST_CODE_CAMERA && grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
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
    public MatHang layDLTuGiaoDien(){
        MatHang mh=new MatHang();
        //   mh.setMaHang(maHang.getText().toString());
        mh.setTenHang(tenHang.getText().toString());
        mh.setDonviHang(donviHang.getText().toString());
        mh.setGiaHang(giaHang.getText().toString());
        mh.setSoluongHang(soluongHang.getText().toString());
        mh.setHinhanh(ConverttoArrayByte(anh));
        return mh;
    }

//lay du lieu ra tu database
    public void capNhatDuLieu() {
        Cursor cursor = dbmh.LayTatCaDuLieuMatHang();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                MatHang mh = new MatHang();
                mh.setMaHang("" + cursor.getInt(0));
                mh.setTenHang(cursor.getString(1));
                mh.setDonviHang(cursor.getString(2));
                mh.setGiaHang("" + cursor.getFloat(3));
                mh.setSoluongHang("" + cursor.getInt(4));
                mh.setHinhanh(cursor.getBlob(5));
    //            mh.setHinhanh(ConverttoArrayByte(anh));
                data.add(mh);

            }

        }


    }


}
