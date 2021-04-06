package com.example.my_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGender, etAge, etHeight, etWeight;
    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValidation()) {
                    String Name, Gender, Age, Height, Weight, cal;
                    Name = etName.getText().toString().trim();
                    Gender = etGender.getText().toString().trim();
                    Age = etAge.getText().toString().trim();
                    Height = etHeight.getText().toString().trim();
                    Weight = etWeight.getText().toString().trim();
                    cal = btnCal.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,com.example.my_application.MainActivity2.class);
                    intent.putExtra("Height",Double.parseDouble(Height));
                    intent.putExtra("Weight",Double.parseDouble(Weight));
                    intent.putExtra("Name",Name);
                    intent.putExtra("Gender",Gender);
                    intent.putExtra("Age",Age);
                    startActivity(intent);
                    finish();
                }
            }
        } );
    }


    private boolean checkValidation() {
        boolean flag = true;
        if (etName.getText().toString().isEmpty()) {
            etName.setError("Please enter the name");
            flag = false;
        }
        if (etGender.getText().toString().isEmpty()) {
            etGender.setError("Please enter the gender");
            flag = false;
        }
        if (etAge.getText().toString().isEmpty()) {
            etAge.setError("Please enter the age");
            flag = false;
        }
        if (etHeight.getText().toString().isEmpty()) {
            etHeight.setError("Please enter the height");
            flag = false;
        }
        if (etWeight.getText().toString().isEmpty()) {
            etWeight.setError("Please enter the weight");
            flag = false;
        }
        return flag;
    }

    private void init() {
        etName=findViewById(R.id.etName);
        etGender = findViewById(R.id.etGender);
        etAge = findViewById(R.id.etAge);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCal = findViewById(R.id.btnCal);
    }
}
