package com.example.appp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customAdapter extends ArrayAdapter {
    Context ctx;
    int layoutid;
    String [] combobox;
    int [] flag;
    public customAdapter(@NonNull Context context, int layoutid, String [] Combobox,int []flag) {
        super(context, layoutid,Combobox);
        {
            this.ctx = context;
            this.layoutid = layoutid;
            this.combobox = Combobox;
            this.flag = flag;
        }
    }

    @Override
    public int getCount() {
        return combobox.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater lI=LayoutInflater.from(ctx);
        convertView=lI.inflate(layoutid,null);
        TextView tenMonan=convertView.findViewById(R.id.textview1);
        ImageView hinhMonAn=convertView.findViewById(R.id.image1);
        return super.getView(position, convertView, parent);
     //   tenMonan.setText(combobox[position]);
   //     hinhMonAn.setImageResource(flag[position]);
    }

}
