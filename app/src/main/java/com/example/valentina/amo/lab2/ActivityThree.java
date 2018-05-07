package com.example.valentina.amo.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.valentina.amo.R;

public class ActivityThree extends AppCompatActivity implements View.OnClickListener{

    TextView list;
    TextView sortedList;
    TextView time;
    Button sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        list = (TextView) findViewById(R.id.list);
        sortedList = (TextView) findViewById(R.id.sortedList);
        time = (TextView) findViewById(R.id.time);
        sort = (Button) findViewById(R.id.sort);

        sort.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.sort:

                // заповнення списку рандомними елементами
                int[] array = new int[50];
                for (int i = 0; i < 50; i++) {
                    array[i] = (1 + (int) (Math.random() * 101));
                }
                String res = "";
                for (int i = 0; i < array.length; i++) {
                    res = res + array[i] + " ";
                }
                // виводимо невідсортований масив
                list.setText(res);

                // Створюємо об'єкст класу QuickSorter
                QuickSorter sorter = new QuickSorter();

                // Старт роботи алгоритму
                long startTime = System.nanoTime();

                // Сортуємо масив
                sorter.sort(array);

                // Кінець роботи алгоритму
                long timeSpent = System.nanoTime() - startTime;

                String res1 = "";
                for (int i = 0; i < array.length; i++) {
                    res1 = res1 + array[i] + " ";
                }
                // виводимо відсортований список список
                sortedList.setText(res1);

                // виводимо час виконання програми
                time.setText(Long.toString(timeSpent) + " нс");
        }
    }
}
