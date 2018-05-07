package com.example.valentina.amo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.valentina.amo.lab2.Main2Activity;
import com.example.valentina.amo.lab3.Main3Activity;
import com.example.valentina.amo.lab4.Main4Activity;
import com.example.valentina.amo.lab5.Main5Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lab2 = (Button) findViewById(R.id.lab2);
        Button lab3 = (Button) findViewById(R.id.lab3);
        Button lab4 = (Button) findViewById(R.id.lab4);
        Button lab5 = (Button) findViewById(R.id.lab5);
        lab2.setOnClickListener(this);
        lab3.setOnClickListener(this);
        lab4.setOnClickListener(this);
        lab5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lab2:
                // рандомний ввід масиву
                Intent intent2 = new Intent(this, Main2Activity.class);
                startActivity(intent2);
                break;
            case R.id.lab3:
                // рандомний масив
                Intent intent3 = new Intent(this, Main3Activity.class);
                startActivity(intent3);
                break;
            case R.id.lab4:
                // графіки
                Intent intent4 = new Intent(this, Main4Activity.class);
                startActivity(intent4);
                break;
            case R.id.lab5:
                // графіки
                Intent intent5 = new Intent(this, Main5Activity.class);
                startActivity(intent5);
                break;
            default:
                break;
        }
    };
}
