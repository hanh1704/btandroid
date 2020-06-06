package com.example.quanlibanhang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class sanphamAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MatHang> mathangList;

    public sanphamAdapter(Context context, int layout, List<MatHang> mathangList) {
        this.context = context;
        this.layout = layout;
        this.mathangList = mathangList;
    }

    @Override
    public int getCount() {
        return mathangList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolderMatHang {
        TextView tvMahang;
        TextView tvTenhang;
        TextView tvDonvi;
        TextView tvGia;
        TextView Soluong;
        ImageView anhh;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderMatHang holderMH;
        if (convertView == null) {

                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(layout, null);
                holderMH = new ViewHolderMatHang();
                //anh xa

                holderMH.tvMahang = convertView.findViewById(R.id.masptv);
                holderMH.tvTenhang = convertView.findViewById(R.id.tensptv);
                holderMH.tvDonvi = convertView.findViewById(R.id.dovitv);
                holderMH.tvGia = convertView.findViewById(R.id.gia);
                holderMH.Soluong = convertView.findViewById(R.id.soluongtv);
                holderMH.anhh=convertView.findViewById(R.id.imageviewsach);
                convertView.setTag(holderMH);


            } else {
                holderMH = (ViewHolderMatHang) convertView.getTag();
            }
            //ppssition cua danhsach
            MatHang mh = mathangList.get(position);
            holderMH.tvMahang.setText(mh.getMaHang());
            holderMH.tvTenhang.setText(mh.getTenHang());
            holderMH.tvDonvi.setText(mh.getDonviHang());
            holderMH.tvGia.setText(mh.getGiaHang());
            holderMH.Soluong.setText(mh.getSoluongHang());
            Bitmap bitmap= BitmapFactory.decodeByteArray(mh.getHinhanh(), 0, mh.hinhanh.length);
             holderMH.anhh.setImageBitmap(bitmap);
            return convertView;
        }



}
