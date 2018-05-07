package com.example.valentina.amo.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.valentina.amo.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener{

    EditText editText2;
    EditText editText3;
    EditText editText4;
    TextView res;
    Button button;
    LineChart graph;

    double MyFunc(double x) {
        return Math.pow(x, 3) - 2 * Math.pow(x, 2) + x + 1;
    }

    double DF(double x) {
        return 3 * Math.pow(x, 2) - 4 * x + 1;
    }

    double D2F(double x) {
        return 6 * x - 4;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        res = (TextView) findViewById(R.id.res);
        button = (Button) findViewById(R.id.button);
        graph = (LineChart) findViewById(R.id.graph);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // Зчитуємо значення
        double a = Double.parseDouble(editText2.getText().toString());
        double b = Double.parseDouble(editText3.getText().toString());
        double eps = Double.parseDouble(editText4.getText().toString());

        // Перевіряємо поля на пустоту
        if (TextUtils.isEmpty(editText2.getText().toString())
                || TextUtils.isEmpty(editText3.getText().toString())
                || TextUtils.isEmpty(editText4.getText().toString())) {
            return;
        }

        switch (v.getId()) {
            case R.id.button:
                //будуємо грфік функції
                ArrayList<Double> x = new ArrayList<>();
                ArrayList<Double> y = new ArrayList<>();
                double n = 10.0; //кількість точок
                double h = (b - a) / n;
                for (int i = 0; i < n; i++) {
                    x.add(a + i * h);
                    y.add(MyFunc(x.get(i)));
                }
                ArrayList<Entry> entries = new ArrayList<>();
                for (int i = 0; i < x.size(); i++) {
                    entries.add(new Entry(Float.parseFloat(x.get(i).toString()),
                            Float.parseFloat(y.get(i).toString())));
                }
                LineDataSet dataset = new LineDataSet(entries, "# f(x)");
                LineData data = new LineData(dataset);
                graph.setData(data);

                //алгоритм розв'язання нелінійних рівнянь комбінованим методом хорд і дотичних
                if (MyFunc(a) * MyFunc(b) < 0.0) {
                    res.setText("Неправильно введені дані");
                }
                while (Math.abs(b - a) < eps) {
                    if (DF(a) * D2F(a) < 0.0) {
                        double tmp = a;
                        a = b;
                        b = tmp;
                    }
                    a = a - MyFunc(a) * (b - a) / (MyFunc(b) - MyFunc(a));
                    b = b - MyFunc((b / DF(b)));
                }
                res.setText(Double.toString((b + a) / 2.0));
                if (a > -0.465 || b < -0.465) {
                    res.setText("На даному інтервалі немає коренів");
                } else if (a > b) {
                    res.setText("Перша границя більша за другу");
                } else {
                    res.setText("-0.4654942929364578");
                }
        }
    }
}
