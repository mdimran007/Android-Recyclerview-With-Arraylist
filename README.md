# Android-Recyclerview-With-Arraylist
![App Image](https://github.com/mdimran007/Android-Recyclerview-With-Arraylist/blob/master/app/src/main/res/drawable-v24/app%20image.jpg)


# Code:

### Step 01

create the activity_main.xml file

```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:scrollbars="vertical"
        />

</RelativeLayout>
```

create the custom_view.xml file

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout android:padding="12dp"
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto">



    <androidx.cardview.widget.CardView
        android:padding="10dp"
        app:cardElevation="3dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:orientation="horizontal">

            <ImageView
                android:id="@+id/flagImage"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:src="@mipmap/ic_launcher"
                />


            <TextView
                android:id="@+id/countryName"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Countery Name"
                android:textSize="25dp"
                android:padding="10dp"
                />

        </LinearLayout>

    </androidx.cardview.widget.CardView>

</LinearLayout>
```

### Step 02

create MyViewHolder.java Class

```
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView countryName;
    ImageView flagImage;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        countryName = (TextView) itemView.findViewById(R.id.countryName);
        flagImage=(ImageView)itemView.findViewById(R.id.flagImage);
    }
}
```

### Step 03

create MyAdapter.java Class

```
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    ArrayList<String> countryName;
    ArrayList<Integer> countryflag;
    Context context;

    public MyAdapter(ArrayList<String> countryName, ArrayList<Integer> countryflag, Context context) {
        this.context=context;
        this.countryName=countryName;
        this.countryflag=countryflag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_view,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.countryName.setText(countryName.get(position));
        holder.flagImage.setImageResource(countryflag.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,countryName.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryName.size();
    }
}
```

### Step 04

MainActivity.java Class

```
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

```
