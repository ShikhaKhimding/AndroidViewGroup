package com.shikha.androidviewgroup;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<String[]> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gridView = findViewById(R.id.gridView);

        dataList = (ArrayList<String[]>) getIntent().getSerializableExtra("dataList");
        ArrayList<String> displayList = new ArrayList<>();

        for (String[] data : dataList) {
            displayList.add("Name: " + data[0] + "\nAge: " + data[1] + "\nOccupation: " + data[2] + "\nAddress: " + data[3]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        gridView.setAdapter(adapter);
    }
}
