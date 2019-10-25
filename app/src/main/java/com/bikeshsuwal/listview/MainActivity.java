package com.bikeshsuwal.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lstcountries;
    public static final String countries[] = {
      "Nepal",
      "India",
      "China",
      "UK",
      "USA",
      "Canada"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstcountries = findViewById(R.id.lstcountries);

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        lstcountries.setAdapter(arrayAdapter);
    }
}
