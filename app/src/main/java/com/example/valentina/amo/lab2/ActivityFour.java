package com.example.valentina.amo.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.valentina.amo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class ActivityFour extends AppCompatActivity {

    LineChart teorGraph;
    LineChart myGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        teorGraph = (LineChart) findViewById(R.id.teorGraph);
        myGraph = (LineChart) findViewById(R.id.myGraph);

        // TODO Auto-generated method stub
        int[] memory = new int[30];
        double[] time = new double[30];
        QuickSorter sorter = new QuickSorter();

        for (int i = 0; i < memory.length; i++){
            memory[i] = i * 10;
            time[i] = (i*10) * Math.log((double) (i*10));

        }
        // визначення часу роботи власного алгоритмому
        // створення масиву
        double[] myTime = new double[300];

        for (int i = 0; i < myTime.length; i++) {

            // створюємо список з n  елементів
            int[] list = new int[i*10];
            for (int j = 0; j < list.length; j++) {
                list[j] = (int)(Math.random() * 100);
            }
            // Старт роботи алгоритму
            long startTime = System.nanoTime();

            // Сортуємо список
            sorter.sort(list);

            // Час роботи алгоритму в наносекундах
            long timeSpent = System.nanoTime() - startTime;
            myTime[i] = (int)timeSpent;
        }

        ArrayList<Entry> entries = new ArrayList<>();
        for(int i = 0; i <memory.length; i++){
            entries.add(new Entry((float) memory[i], (float)time[i]));
        }
        LineDataSet dataset = new LineDataSet(entries, "# к-ть/нс");
        LineData data = new LineData(dataset);
        teorGraph.setData(data);

        ArrayList<Entry> entries1 = new ArrayList<>();
        for(int i = 0; i <memory.length; i++){
            entries1.add(new Entry((float) memory[i], (float)myTime[i]));
        }
        LineDataSet dataset1 = new LineDataSet(entries1, "# к-ть/нс");
        LineData data1 = new LineData(dataset1);
        myGraph.setData(data1);
    }
}
