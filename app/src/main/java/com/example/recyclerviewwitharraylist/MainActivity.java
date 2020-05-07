package com.example.recyclerviewwitharraylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> countryName=new ArrayList<>(Arrays.asList("Afghanistan","Bangladesh","China","Denmark","Ecuador","France","Greece","Hungary","India","Japan"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter =new MyAdapter(countryName,this);
        recyclerView.setAdapter(myAdapter);
    }
}
