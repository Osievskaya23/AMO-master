package com.example.valentina.amo.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.valentina.amo.R;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener{

    EditText array;
    TextView result;
    TextView time;
    Button sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        array = (EditText) findViewById(R.id.array);
        result = (TextView) findViewById(R.id.result);
        time = (TextView) findViewById(R.id.time);
        sort = (Button) findViewById(R.id.sort);

        sort.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // Зчитуємо значення
        String strigList = array.getText().toString();

        // Перевіряємо поля на пустоту
        if (TextUtils.isEmpty(array.getText().toString())) {
            return;
        }

        switch (v.getId()) {
            case R.id.sort:
                // Формуємо масив чисел
                String[] array = strigList.split(" ");
                int[] list = new int[array.length];
                for (int i = 0; i < array.length; i++) {
                    list[i] = Integer.parseInt(array[i]);
                }
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
