package com.bikeshsuwal.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CapitalActivity extends AppCompatActivity {

    private TextView txtCapital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capital);

        txtCapital = findViewById(R.id.txtCapital);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String capital = bundle.getString("capital");
            txtCapital.setText(capital);
        }
        else {
            txtCapital.setText("NO data");
        }
    }
}
