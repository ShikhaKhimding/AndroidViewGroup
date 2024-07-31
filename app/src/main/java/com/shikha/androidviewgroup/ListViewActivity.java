package com.shikha.androidviewgroup;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String[]> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

        dataList = (ArrayList<String[]>) getIntent().getSerializableExtra("dataList");
        ArrayList<String> displayList = new ArrayList<>();

        for (String[] data : dataList) {
            displayList.add("Name: " + data[0] + "\nAge: " + data[1] + "\nOccupation: " + data[2] + "\nAddress: " + data[3]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        listView.setAdapter(adapter);
    }
}
