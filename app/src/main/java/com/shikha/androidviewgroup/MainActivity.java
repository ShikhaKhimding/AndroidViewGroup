package com.shikha.androidviewgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextOccupation, editTextAddress;
    private Button buttonAdd, buttonListView, buttonGridView, buttonRecyclerView;
    private ArrayList<String[]> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextOccupation = findViewById(R.id.editTextOccupation);
        editTextAddress = findViewById(R.id.editTextAddress);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonListView = findViewById(R.id.buttonListView);
        buttonGridView = findViewById(R.id.buttonGridView);
        buttonRecyclerView = findViewById(R.id.buttonRecyclerView);

        dataList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToList();
            }
        });

        buttonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToListView();
            }
        });

        buttonGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGridView();
            }
        });

        buttonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRecyclerView();
            }
        });
    }

    private void addDataToList() {
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();
        String occupation = editTextOccupation.getText().toString();
        String address = editTextAddress.getText().toString();

        if (!name.isEmpty() && !age.isEmpty() && !occupation.isEmpty() && !address.isEmpty()) {
            dataList.add(new String[]{name, age, occupation, address});
            clearFields();
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        editTextName.setText("");
        editTextAge.setText("");
        editTextOccupation.setText("");
        editTextAddress.setText("");
    }

    private void navigateToListView() {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        intent.putExtra("dataList", dataList);
        startActivity(intent);
    }

    private void navigateToGridView() {
        Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
        intent.putExtra("dataList", dataList);
        startActivity(intent);
    }

    private void navigateToRecyclerView() {
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        intent.putExtra("dataList", dataList);
        startActivity(intent);
    }
}
