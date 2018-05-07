package com.example.valentina.amo.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.valentina.amo.R;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener{

    EditText amount;
    EditText lower;
    EditText upper;

    TextView array;
    TextView result;
    TextView time;
    Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        amount = (EditText) findViewById(R.id.amount);
        lower = (EditText) findViewById(R.id.lower);
        upper = (EditText) findViewById(R.id.upper);
        array = (TextView) findViewById(R.id.array);
        result = (TextView) findViewById(R.id.result);
        time = (TextView) findViewById(R.id.time);
        go = (Button) findViewById(R.id.Go);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // Зчитуємо значення
        int Amount = Integer.parseInt(amount.getText().toString());
        int Lower = Integer.parseInt(lower.getText().toString());
        int Upper = Integer.parseInt(upper.getText().toString());

        // Перевіряємо поля на пустоту
        if (TextUtils.isEmpty(amount.getText().toString())
                || TextUtils.isEmpty(lower.getText().toString())
                || TextUtils.isEmpty(upper.getText().toString())){
            return;
        }

        switch (v.getId()) {
            case R.id.Go:

                // заповнення списку рандомними елементами
                int[] list = new int[Amount];
                for(int i = 0; i < Amount; i++) {
                    list[i] = (Lower + (int) (Math.random() * Upper));
                }
                String res = "";
                for(int i = 0; i < list.length; i++){
                    res = res + list[i] + " ";
                }
                // виводимо невідсортований масив
                array.setText(res);

                // Створюємо об'єкст класу QuickSorter
                QuickSorter sorter = new QuickSorter();

                // Старт роботи алгоритму
                long startTime = System.nanoTime();

                // Сортуємо масив
                sorter.sort(list);

                // Кінець роботи алгоритму
                long timeSpent = System.nanoTime() - startTime;

                String res1 = "";
                for(int i = 0; i < list.length; i++){
                    res1 = res1 + list[i] + " ";
                }
                // виводимо відсортований список список
                result.setText(res1);

                // виводимо час виконання програми
                time.setText(Long.toString(timeSpent) + " нс");

        }
    }
}
