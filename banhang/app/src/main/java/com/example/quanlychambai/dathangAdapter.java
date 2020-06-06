package com.example.quanlychambai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class dathangAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    List<DatHangSanPham> DHSPList;

    public dathangAdapter(Context context, int layoutResourceId, List<DatHangSanPham> DHSPList) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.DHSPList = DHSPList;
    }

    @Override
    public int getCount() {
        return DHSPList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class DatHangHolder {
        TextView txt1, txt2, txt3, txt4;
    }

    @Override
    public View getView(int position, View convert, ViewGroup parent) {
        dathangAdapter.DatHangHolder holder = new dathangAdapter.DatHangHolder();

        if (convert != null) {
            holder = (dathangAdapter.DatHangHolder ) convert.getTag();
        } else {
            convert = LayoutInflater.from(context).inflate(R.layout.item_listview, parent, false);
            holder.txt1 = (TextView) convert.findViewById(R.id.ngaydat);
            holder.txt2 = (TextView) convert.findViewById(R.id.soluong);
            holder.txt3 = (TextView) convert.findViewById(R.id.sanpham);
            holder.txt4 = (TextView) convert.findViewById(R.id.tenKH);

            convert.setTag(holder);
        }

        DatHangSanPham hd = DHSPList.get(position);

//        holder.img.setImageResource(R.drawable.logo);
        holder.txt1.setText( hd.getNgaydat());
        holder.txt2.setText(hd.getSoluong());
        holder.txt3.setText(hd.getSanpham());
        holder.txt4.setText(hd.getKhachhang());

        return convert;
    }

}
