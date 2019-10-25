package com.bikeshsuwal.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView lstcountries;
    public static final String countries[] = {
      "Nepal", "Kathmandu",
      "India", "New Delhi",
      "China", "Beijing",
      "UK", "London",
      "USA", "Washington DC",
      "Canada", "Ottawa"
    };

    //for hashMap
    private Map<String, String> countriesMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstcountries = findViewById(R.id.lstcountries);

        countriesMap = new HashMap<>();

        for (int i = 0; i < countries.length; i += 2){
            countriesMap.put(countries[i], countries[i + 1]);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList(countriesMap.keySet())
        );

        lstcountries.setAdapter(arrayAdapter);

        lstcountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();        // to get clicked country name (to get clicked key)
                String capital = countriesMap.get(country);         // to get capital name of clicked country(to get value of clicked key)
//                Toast.makeText(MainActivity.this, "The Capital City of "+country+" is "+capital, Toast.LENGTH_LONG).show();      // to show the capital(to show the value)

                //for running new activity
                Intent intent = new Intent(MainActivity.this,CapitalActivity.class);
                intent.putExtra("capital",capital); //passing the value to another activity
                startActivity(intent);
            }
        });

    }
}
