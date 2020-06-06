package com.example.dat_do_an;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customadapter_thucuong extends ArrayAdapter {
    Context context;
    int layoutID;
    String[] listnuocuong;
    int [] anh;

    public customadapter_thucuong(Context context, int layoutID, String[] listnuocuong, int[] anh) {
        super(context, layoutID);
        this.context=context;
        this.layoutID=layoutID;
        this.listnuocuong = listnuocuong;
        this.anh = anh;
    }

    @Override
    //đếm số data
    public int getCount() {
        return listnuocuong.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ini = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = ini.inflate(layoutID, null);
        TextView tenFood = convertView.findViewById(R.id.textviewdrink);
        ImageView anhh = convertView.findViewById(R.id.lvdrink);
        tenFood.setText(listnuocuong[position]);
        anhh.setImageResource(anh[position]);
        return convertView;
    }
}
