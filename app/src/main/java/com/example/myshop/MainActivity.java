package com.example.myshop;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.EventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_info, btn_guide, btn_call, btn_login;
    EditText user_id, passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*login area*/
        user_id = findViewById(R.id.userid);
        passwd = findViewById(R.id.passwd);
        btn_login = findViewById(R.id.btn_login);

        /*content area*/
        btn_info = findViewById(R.id.btn_info);
        btn_guide = findViewById(R.id.btn_guide);
        btn_call = findViewById(R.id.btn_call);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(MainActivity.this, "응애 나 애기 중붕", Toast.LENGTH_SHORT).show();*/
                //Log.d("JB","Button is clicked");

                String strId = user_id.getText().toString();
                String strPwd = passwd.getText().toString();

                if (strId.length() > 5) {
                    Log.d("JB", "id's limit is 5 letters(code:id)");
                } else if (strPwd.length() > 8) {
                    Log.d("JB", "pwd's limit is 8 letters(code:pwd)");
                } else {
                    String returnText = strId.equals("30505") && strPwd.equals("12345678") ? "welcome." : "please check your id and password again.";
                    Log.d("JB", returnText);
                }
            }
        });

        btn_info.setOnClickListener(this);
        btn_guide.setOnClickListener(this);
        btn_call.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId())
        {
            case R.id.btn_info:
                intent = new Intent(MainActivity.this, InfoActivity.class);
                Toast.makeText(this, "information", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_guide:

                intent = new Intent(MainActivity.this, GuideActivity.class);
                Toast.makeText(this, "guide", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_call:

                intent = new Intent(MainActivity.this, CallActivity.class);
                Toast.makeText(this, "call", Toast.LENGTH_SHORT).show();
                break;
        }
        try{
            startActivity(intent);
        }
        catch(Exception e)
        {
            Log.d("JB","Error("+e.getMessage()+")");
        }

    }
}