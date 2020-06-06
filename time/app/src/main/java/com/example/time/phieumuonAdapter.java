package com.example.time;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class phieumuonAdapter extends BaseAdapter {
    private Context context;

    private int layout;
    private List<phieumuon> phieumuonList;

    public phieumuonAdapter(Context context, int layout, List<phieumuon> phieumuonList) {
        this.context = context;
        this.layout = layout;
        this.phieumuonList = phieumuonList;
    }

    @Override
    public int getCount() {
        return phieumuonList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        // ImageView imgAvatar;

        TextView tvTenSach;
        TextView tvdocgia;
        TextView tvngaymuon;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            holder = new ViewHolder();
            //anh xa
            // holder.imgAvatar=convertView.findViewById(R.id.imageviewsach);
            holder.tvngaymuon = convertView.findViewById(R.id.textviewngay);
            holder.tvTenSach = convertView.findViewById(R.id.texviewtensach);
            holder.tvdocgia = convertView.findViewById(R.id.textviewdocgia);
            convertView.setTag(holder);


        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        phieumuon pm = phieumuonList.get(position);
        //  holder.imgAvatar.setImageResource();
        holder.tvTenSach.setText(pm.getTensach());
        holder.tvdocgia.setText(pm.getDocgia());
        holder.tvngaymuon.setText(pm.getNgaymuon());

        return convertView;
    }
}