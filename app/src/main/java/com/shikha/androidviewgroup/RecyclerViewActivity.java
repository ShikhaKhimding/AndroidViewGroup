package com.shikha.androidviewgroup;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String[]> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = (ArrayList<String[]>) getIntent().getSerializableExtra("dataList");
        ArrayList<String> displayList = new ArrayList<>();

        for (String[] data : dataList) {
            displayList.add("Name: " + data[0] + "\nAge: " + data[1] + "\nOccupation: " + data[2] + "\nAddress: " + data[3]);
        }

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(displayList);
        recyclerView.setAdapter(adapter);
    }
}
