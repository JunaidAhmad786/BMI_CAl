package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    TextView tvresult,tvresult1,tvresult2,tvresult3;
    Button btnGoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvresult = findViewById(R.id.tvresult);
        tvresult1=findViewById(R.id.tvresult1);
        tvresult2=findViewById(R.id.tvresult2);
        tvresult3=findViewById(R.id.tvresult3);
        btnGoback=findViewById(R.id.btnGoback);
        Intent intent = getIntent();
        double getheight = intent.getDoubleExtra("Height", -1);
        double getwaightt = intent.getDoubleExtra("Weight", -1);
        String getName=intent.getStringExtra("Name");
        String getGender=intent.getStringExtra("Gender");
        String getAge=intent.getStringExtra("Age");
        double finalresult = getheight/100;
        double finalresultt=((getwaightt)/(finalresult*finalresult));
        String d;
        DecimalFormat sd = new DecimalFormat("##.00");
        d=sd.format(finalresultt);
        tvresult.setText(d);
        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = "Junaid_result.txt";
                String data = getName+ ", "+ getGender+ ", "+ getAge+", "+getheight+ ", "+ getwaightt+"\n";
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = openFileOutput(file,MODE_APPEND);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    ((FileOutputStream) fileOutputStream).write(data.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intet = new Intent(MainActivity2.this,com.example.my_application.MainActivity.class);
                startActivity(intet);
                finish();
            }
        });

        if(finalresultt<18.5) {
            tvresult1.setText("Body mass deficit");
        }
        else if(finalresultt>18.5 && finalresultt<=24.9){
            tvresult1.setText("Normal body mass");
        }
        else if(finalresultt>=25.0 && finalresultt<=29.9) tvresult1.setText("Excessive body mass");
        else if(finalresultt>30.0 && finalresultt<=34.9){
            tvresult1.setText("Obesity 1st degree");
        }
        else if(finalresultt>35.0 && finalresultt<=39.9){
            tvresult1.setText("Obesity 2nd degree");
        }
        else if(finalresultt>40.0 ){
            tvresult1.setText("Extreme high");
        }
        else {
            tvresult1.setText("Danger");
        }
        if(finalresultt>=18.0 && finalresultt<= 25.0) {
          tvresult2.setText("Normal BMI Rangs is 18-25\n");
            tvresult3.setText("Your BMI is good");
        }
        else if(finalresultt<=18.0 && finalresultt> 25.0) {
                tvresult2.setText("Normal BMI Rangs is 18-25");
                tvresult3.setText("Try to execute ");
            }
        else
            tvresult2.setText("Syntax error");
        }
        }


