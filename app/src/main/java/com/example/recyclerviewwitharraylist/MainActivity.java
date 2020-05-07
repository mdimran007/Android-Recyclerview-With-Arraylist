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
    ArrayList<Integer> countryflag=new ArrayList<>(Arrays.asList(R.drawable.afghanistan,R.drawable.bangladesh,R.drawable.china,R.drawable.denmark,R.drawable.ecuador,R.drawable.france,R.drawable.greece,R.drawable.hungary,R.drawable.india,R.drawable.japan));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView= (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyAdapter myAdapter =new MyAdapter(countryName,countryflag, this);
        recyclerView.setAdapter(myAdapter);
    }
}
