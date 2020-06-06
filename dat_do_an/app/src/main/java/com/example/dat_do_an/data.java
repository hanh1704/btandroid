package com.example.dat_do_an;

import androidx.annotation.NonNull;

public class data {
    public String []mang =new String[2];

    public data(String[] mang) {
        this.mang = mang;
    }
    public data()
    {}


    public String[] getMang() {
        return mang;
    }

    public void setMang(String[] mang) {
        this.mang = mang;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
