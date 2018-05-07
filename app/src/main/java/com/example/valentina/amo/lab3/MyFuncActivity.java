package com.example.valentina.amo.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.valentina.amo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Iterator;

public class MyFuncActivity extends AppCompatActivity implements View.OnClickListener{

    LineChart graph;
    EditText xxx;
    Button er;
    Button ok;

    public Iterable<Double> firstFormat(ArrayList<Double> Xi, double x){
        ArrayList<Double> geomSum = new ArrayList<>();
        for (int i = 0; i<Xi.size(); i++){
            double sum = 1;
            for (int j = 0; j < i; j++){
                sum *= (x - Xi.get(j));
            }
            geomSum.add(sum);
        }
        geomSum.remove(0);
        return geomSum;
    }

    public ArrayList<Double> secondFormat(ArrayList<Double> Y, ArrayList<Double> X,
                                          ArrayList<Double> res, int deap){
        ArrayList<Double> divide = new ArrayList<>();
        double y;
        for (int i = 0; i < Y.size() -1; i++) {
            y = (Y.get(i+1) - Y.get(i)) / (X.get(i + deap + 1) - X.get(i));
            divide.add(y);
        }
        if (!res.addAll(divide))
            throw new NumberFormatException();
        if (divide.size() == 1)
            return res;
        deap++;
        return secondFormat(divide, X, res, deap);
    }

    public double newton(ArrayList<Double> x, ArrayList<Double> y, double x1) {

        // многочлен Ньютона
        Iterator<Double> firstFormat = firstFormat(x, x1).iterator();
        ArrayList<Double> secondFormat = new ArrayList<>();
        secondFormat(y, x, secondFormat, 0);

        double Nx = y.get(0);
        int iter = 0;
        int len = x.size() - 1;
        while (firstFormat.hasNext()) {
            Nx += firstFormat.next() * secondFormat.get(iter);
            iter += len;
            len--;
        }
        return Nx;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_func);

        graph = (LineChart) findViewById(R.id.graph);
        xxx = (EditText) findViewById(R.id.x);
        er = (Button) findViewById(R.id.er);
        ok = (Button) findViewById(R.id.ok);

        er.setOnClickListener(this);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {
            case R.id.ok:
                int a = 0;
                int b = 3;
                int n = 10; // кількість точок
                double h = (b - a) / 10.0;
                // знаходимо координати початкового графіку
                ArrayList<Double> x = new ArrayList<>();
                ArrayList<Double> y = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    x.add(a + h * i);
                    y.add(3*Math.pow(Math.cos(x.get(i)), 2)-Math.sqrt(x.get(i)));
                }

                // Знаходимо значення інтерполяційної функції
                ArrayList<Double> func = new ArrayList<>();
                for (int i = 0; i < x.size(); i++) {
                    func.add(newton(x, y, x.get(i)));
                }
                ArrayList<Entry> entries = new ArrayList<>();
                for(int i = 0; i <x.size(); i++){
                    entries.add(new Entry(Float.parseFloat(x.get(i).toString()),
                            Float.parseFloat(func.get(i).toString())));
                }
                LineDataSet dataset = new LineDataSet(entries, "# my function f(x)");
                LineData data = new LineData(dataset);
                graph.setData(data);
                // Зчитуємо значення
                double x1 = Double.parseDouble(xxx.getText().toString());;

                // Перевіряємо поля на пустоту
                if (TextUtils.isEmpty(xxx.getText().toString())){
                    return;
                }

            case R.id.er:
                // f(x)
                Intent intent = new Intent(this, Errorsa.class);
                startActivity(intent);
                break;
/*
                // координати графа похибки Ньютона
                ArrayList<Entry> entries = new ArrayList<>();
                for (int i = 0; i < x.size(); i++) {
                    entries.add(new Entry(Float.parseFloat(x.get(i).toString()),
                            Float.parseFloat(NewtonError.get(i).toString() )));
                }
                // координати графа інтерполяційного многочлена Ньютона
                ArrayList<Entry> entriesF = new ArrayList<>();
                for (int i = 0; i < x.size(); i++) {
                    entriesF.add(new Entry(Float.parseFloat(x.get(i).toString()),
                            Float.parseFloat(func.get(i).toString())));
                }
                // граф початкової функції
                LineDataSet dataset = new LineDataSet(entries, "# sin(x)");
                dataset.setCircleColor(Color.parseColor("#FF0000"));
                dataset.setColors(Color.parseColor("#FF0000"));
                dataset.setAxisDependency(YAxis.AxisDependency.LEFT);

                // граф інтерполяційного многочлена Ньютона
                LineDataSet datasetF = new LineDataSet(errorEntries, "# Newton error");
                datasetF.setCircleColor(Color.parseColor("#0000CD"));
                datasetF.setColors(Color.parseColor("#0000CD"));
                datasetF.setAxisDependency(YAxis.AxisDependency.LEFT);

                // побудова графіка
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(dataset);
                dataSets.add(datasetF);

                LineData data = new LineData(dataSets);
                graph.setData(data);
                graph.invalidate();*/
        }
    }
}
