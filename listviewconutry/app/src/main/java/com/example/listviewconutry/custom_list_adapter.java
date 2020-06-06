package com.example.listviewconutry;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class custom_list_adapter extends ArrayAdapter {
    // private ArrayList<country> listdata;
    //chuyen layout xml sang view
    Context context;
    String countrylist[];
    int flag[];
    int layoutID;
    int population[];


    public custom_list_adapter(Context context, int layoutID,String[] countrylist, int[] flag,  int[] population) {
        //super();
        super(context,layoutID);
        this.context = context;
        this.countrylist = countrylist;
        this.flag = flag;
        this.layoutID = layoutID;
        this.population = population;
    }

    @Override
    //đếm số data
    public int getCount() {
        return countrylist.length;
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
        TextView country = convertView.findViewById(R.id.text1);
        TextView danso = convertView.findViewById(R.id.text2);
        ImageView anh = convertView.findViewById(R.id.image);
        country.setText(countrylist[position]);
        danso.setText(String.valueOf(population[position]));
        anh.setImageResource(flag[position]);
        return convertView;


    }
}
