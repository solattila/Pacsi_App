package com.example.pacsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainmenu extends AppCompatActivity implements View.OnClickListener {

    private Button btnSingleMain;
    private Button btnMultiMain;
    private Button btnPhotosMain;
    private Button btnInfoMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btnSingleMain = findViewById(R.id.btnSingleMain);
        btnMultiMain = findViewById(R.id.btnMultiMain);
        btnPhotosMain = findViewById(R.id.btnPhotosMain);
        btnInfoMain = findViewById(R.id.btnInfoMain);

        btnSingleMain.setOnClickListener(this);
        btnMultiMain.setOnClickListener(this);
        btnPhotosMain.setOnClickListener(this);
        btnInfoMain.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnSingleMain:
                Intent intentSingle = new Intent(mainmenu.this, SingleActivity.class);
                startActivity(intentSingle);
                break;

            case R.id.btnMultiMain:
                Intent intentMulti = new Intent(mainmenu.this, MultiActivity.class);
                startActivity(intentMulti);
                break;

            case R.id.btnPhotosMain:
                break;

            case R.id.btnInfoMain:
                break;

        }

    }
}
