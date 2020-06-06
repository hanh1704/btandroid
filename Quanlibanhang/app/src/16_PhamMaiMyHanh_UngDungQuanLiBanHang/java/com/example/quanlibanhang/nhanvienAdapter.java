package com.example.quanlibanhang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class nhanvienAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    List<Nhanvien> data = null;

    public nhanvienAdapter(Context context, int layoutResourceId, List<Nhanvien> data) {
       // super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    public class NhanVienHolder {
        TextView txt1, txt2, txt3, txt4,txt5,txt6;
        ImageView anhh;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        nhanvienAdapter.NhanVienHolder holder = new nhanvienAdapter.NhanVienHolder();

        if (convert != null) {
            holder = (nhanvienAdapter.NhanVienHolder) convert.getTag();
        } else {
            convert = LayoutInflater.from(context).inflate(R.layout.item_nhanvien,parent,false);
            holder.txt1 = (TextView) convert.findViewById(R.id.manvet);
            holder.txt2 = (TextView) convert.findViewById(R.id.passwordet);
            holder.txt3 = (TextView) convert.findViewById(R.id.tennv);
            holder.txt4 = (TextView) convert.findViewById(R.id.sdtnvet);
            holder.txt5 = (TextView) convert.findViewById(R.id.diachinvet);
            holder.txt6 = (TextView) convert.findViewById(R.id.chucvuet);
            holder.anhh=convert.findViewById(R.id.imageviewnv);

            convert.setTag(holder);
        }

        Nhanvien kh = data.get(position);

//        holder.img.setImageResource(R.drawable.logo);
        holder.txt1.setText(kh.getUsername());
        holder.txt2.setText(kh.getPass());
        holder.txt3.setText( kh.getTen());
        holder.txt4.setText( kh.getSdt());
        holder.txt5.setText( kh.getDiachi());
        holder.txt6.setText( kh.getChucvu());
        Bitmap bitmap= BitmapFactory.decodeByteArray(kh.getHinhanh(), 0, kh.hinhanh.length);
        holder.anhh.setImageBitmap(bitmap);

        return convert;
    }

}


