package com.example.dat_do_an;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customadapter_thucan extends ArrayAdapter {
   Context context;
    int layoutID;
    String[] listmonan;
    int [] anh;

    public customadapter_thucan( Context context, int layoutID, String[] listmonan, int[] anh) {
        super(context, layoutID);
        this.context=context;
        this.layoutID=layoutID;
        this.listmonan = listmonan;
        this.anh = anh;
    }

    @Override
    //đếm số data
    public int getCount() {
        return listmonan.length;
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
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater ini = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = ini.inflate(layoutID, null);
        TextView tenFood = convertView.findViewById(R.id.textviewfood);
        ImageView anhh = convertView.findViewById(R.id.lvfood);
        tenFood.setText(listmonan[position]);
        anhh.setImageResource(anh[position]);
        return convertView;
    }
}
