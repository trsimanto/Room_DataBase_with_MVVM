package com.towhid.roomdatabasewithmvvm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SemisterViewModel semisterViewModel;
    RecyclerView rec_semister;
    Button add_semister;
    RecyclerAdapterSemisterList recyclerAdapterSemisterList;
    List<Semister> semisterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        semisterViewModel = ViewModelProviders.of(this).get(SemisterViewModel.class);
        rec_semister=(RecyclerView)findViewById(R.id.rec_semister);
        add_semister=(Button) findViewById(R.id.add_semister);
        semisterList = new ArrayList<>();
        recyclerAdapterSemisterList=new RecyclerAdapterSemisterList(this,semisterList);
        rec_semister.setLayoutManager(new LinearLayoutManager(this));
        rec_semister.setAdapter(recyclerAdapterSemisterList);

        semisterViewModel.getAllSemister().observe(this, new Observer<List<Semister>>() {
            @Override
            public void onChanged(@Nullable List<Semister> semisters) {
                semisterList.clear();
                semisterList.addAll(semisters);
                assert semisters != null;
                Toast.makeText(MainActivity.this, semisters.size()+"", Toast.LENGTH_SHORT).show();
                recyclerAdapterSemisterList.notifyDataSetChanged();
            }
        });
        add_semister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
