package com.example.valentina.amo.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.valentina.amo.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView titleText1 = (TextView) findViewById(R.id.titleText1);
        Button manualInput = (Button) findViewById(R.id.manualInput);
        Button randomInput = (Button) findViewById(R.id.randomInput);
        Button fileInput = (Button) findViewById(R.id.fileInput);
        Button grafics = (Button) findViewById(R.id.Grafics);
        manualInput.setOnClickListener(this);
        randomInput.setOnClickListener(this);
        fileInput.setOnClickListener(this);
        grafics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manualInput:
                // ввід масиву вручну
                Intent intent = new Intent(this, ActivityOne.class);
                startActivity(intent);
                break;
            case R.id.randomInput:
                // рандомний ввід масиву
                Intent intent2 = new Intent(this, ActivityTwo.class);
                startActivity(intent2);
                break;
            case R.id.fileInput:
                // рандомний масив
                Intent intent3 = new Intent(this, ActivityThree.class);
                startActivity(intent3);
                break;
            case R.id.Grafics:
                // графіки
                Intent intent4 = new Intent(this, ActivityFour.class);
                startActivity(intent4);
                break;
            default:
                break;
        }
    };
}
