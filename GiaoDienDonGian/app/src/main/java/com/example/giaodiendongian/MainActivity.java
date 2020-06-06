package com.example.giaodiendongian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    ImageView im1;

    RadioButton hinh1,hinh2,hinh3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        setControl();
        setEvent();
    }
    private void setControl()
    {
        im1=(ImageView)findViewById(R.id.im1);
        hinh1=(RadioButton) findViewById(R.id.h1);
        hinh2=(RadioButton) findViewById(R.id.h2);
        hinh3=(RadioButton) findViewById(R.id.h3);
    }
    private void setEvent()
    {


                if (hinh1.isChecked()) {
                    im1.setImageResource(R.drawable.hinh1);
                }
//                if (hinh2.isChecked()) {
//                    im1.setImageResource(R.drawable.hinh2);
//                }
//                if (hinh3.isChecked()) {
//                    im1.setImageResource(R.drawable.pic);
//                }
            }


}
