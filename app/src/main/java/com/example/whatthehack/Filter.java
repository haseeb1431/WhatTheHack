package com.example.whatthehack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Filter extends AppCompatActivity {

    RadioButton btn_filter0;
    RadioButton btn_filter1;
    RadioButton btn_filter2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        btn_filter0 = findViewById(R.id.filter0);
        btn_filter1 = findViewById(R.id.filter1);
        btn_filter2 = findViewById(R.id.filter2);

        //Set filters to checked
        btn_filter0.setChecked(MainActivity.current_filters[0]);
        btn_filter1.setChecked(MainActivity.current_filters[1]);
        btn_filter2.setChecked(MainActivity.current_filters[2]);

        btn_filter0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.current_filters[0] = !MainActivity.current_filters[0];
                btn_filter0`.setChecked(MainActivity.current_filters[0]);
            }
        });

        btn_filter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.current_filters[1] = !MainActivity.current_filters[1];
                btn_filter1.setChecked(MainActivity.current_filters[1]);
            }
        });

        btn_filter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.current_filters[2] = !MainActivity.current_filters[2];
                btn_filter2.setChecked(MainActivity.current_filters[2]);
            }
        });
    }

}
