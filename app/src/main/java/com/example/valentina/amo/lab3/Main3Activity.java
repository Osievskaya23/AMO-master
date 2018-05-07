package com.example.valentina.amo.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.valentina.amo.R;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button sin = (Button) findViewById(R.id.sin);
        Button myFunc = (Button) findViewById(R.id.myFunc);

        sin.setOnClickListener(this);
        myFunc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sin:
                // sin(x)
                Intent intent = new Intent(this, SinActivity.class);
                startActivity(intent);
                break;
            case R.id.myFunc:
                // 3*cos^2(x) - x^(1/2)
                Intent intent2 = new Intent(this, MyFuncActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    };
}
