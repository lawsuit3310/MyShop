package com.example.myshop;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageInfo;
    TextView textInfo;
    Button btnInfoBack;
    int no = 0;
    int imgs[] = {R.drawable.kyoto,R.drawable.istanbul,R.drawable.shine, R.drawable.lunden,R.drawable.lutetia_parisiorum};
    String text[] = {"1번 이미지 설명","2번 이미지 설명","3번 이미지 설명","4번 이미지 설명","5번 이미지 설명"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageInfo = findViewById(R.id.image_info);
        btnInfoBack = findViewById(R.id.btn_info_back);
        textInfo = findViewById(R.id.text_info);


        imageInfo.setImageResource(imgs[0]);
        textInfo.setText(text[0]);

        btnInfoBack.setOnClickListener(this);
        imageInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                no = ++no %5;
                imageInfo.setImageResource(imgs[no]);
                textInfo.setText(text[no]);
            }
        });


    }

    @Override
    public void onClick(View view) {
        finish();
    }
}