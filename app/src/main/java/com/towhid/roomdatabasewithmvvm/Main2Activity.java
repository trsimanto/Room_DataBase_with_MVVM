package com.towhid.roomdatabasewithmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText smisternameet;
    EditText semistergpaet;
    EditText semistercreditet;
    Button addbutton;
    SemisterViewModel semisterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        semisterViewModel = ViewModelProviders.of(this).get(SemisterViewModel.class);
        addbutton = findViewById(R.id.addbutton);
        semistercreditet = findViewById(R.id.semistercredit);
        semistergpaet = findViewById(R.id.semistergpa);
        smisternameet = findViewById(R.id.semistername);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gpa = Double.parseDouble(semistergpaet.getText().toString());
                double credit = Double.parseDouble(semistercreditet.getText().toString());
                String name = smisternameet.getText().toString();
                Semister temp = new Semister(name, gpa, credit);
                semisterViewModel.insertSemister(temp);
                finish();
            }
        });
    }
}
