package com.example.quanlibanhang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HoaDonAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    List<HoaDon> hoadonList;

    public HoaDonAdapter(Context context, int layoutResourceId, List<HoaDon> hoadonList) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.hoadonList = hoadonList;
    }

    @Override
    public int getCount() {
        return hoadonList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class HoaDonHolder {
        TextView txt1, txt2, txt3, txt4, txt5, txt6;
    }

    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        HoaDonAdapter.HoaDonHolder holder = new HoaDonAdapter.HoaDonHolder();

        if (convert != null) {
            holder = (HoaDonAdapter.HoaDonHolder ) convert.getTag();
        } else {
            convert = LayoutInflater.from(context).inflate(R.layout.item_hoadon, parent, false);
            holder.txt1 = (TextView) convert.findViewById(R.id.mahdet);
            holder.txt2 = (TextView) convert.findViewById(R.id.ngaylap);
            holder.txt3 = (TextView) convert.findViewById(R.id.maKh_hd);
            holder.txt4 = (TextView) convert.findViewById(R.id.tenspHDtv);
            holder.txt5 = (TextView) convert.findViewById(R.id.soluongHDtv);
            holder.txt6 = (TextView) convert.findViewById(R.id.thanhtienHDtv);

            convert.setTag(holder);
        }

        HoaDon hd = hoadonList.get(position);

//        holder.img.setImageResource(R.drawable.logo);
        holder.txt1.setText( hd.getSoHD());
        holder.txt2.setText( hd.getNgayLap());
        holder.txt3.setText(hd.getMakhHD());
        holder.txt4.setText(hd.getTenspHD());
        holder.txt5.setText(hd.getSoluongHD());
        holder.txt6.setText(hd.getThanhtienHD());

        return convert;
    }



}

