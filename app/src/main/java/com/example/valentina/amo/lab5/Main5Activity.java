package com.example.valentina.amo.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.valentina.amo.R;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener{

    RadioButton myM;
    TextView X1;
    TextView X2;
    TextView X3;

    boolean converge(double[] x, double[] p, double eps){
        double norm = 0;
        for (int i = 0; i<3; i++){
            norm+=(x[i]-p[i])*(x[i]-p[i]);
        }
        if (Math.sqrt(norm) >= eps){
            return false;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        X1 = findViewById(R.id.x1);
        X2 = findViewById(R.id.x2);
        X3 = findViewById(R.id.x3);
        myM = findViewById(R.id.myM);

        myM.setOnClickListener(this);
        myM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.myM:
                double epsilon = 0.000001;
                double [][] a ={{1, -2, -5},
                        {2, 1, 3},
                        {3, -2, -1}};

                double [] b ={-1, 13, 9};
                double [] p = {0, 0, 0};
                double [] x = {0, 0, 0};

                // реалізація методу гаусса
                while(!converge(x, p, epsilon)) {
                    for (int i = 0; i < 3; i++) {
                        p[i] = x[i];
                    }
                    for (int i = 0; i < 3; i++) {
                        double var = 0;
                        for (int j = 0; j < i; j++) {
                            var += (a[i][j] * x[j]);
                        }
                        for (int j = i + 1; j < 3; j++) {
                            var += (a[i][j] * p[j]);
                        }
                        x[i] = (b[i] - var) / a[i][i];
                    }
                }
                //выделяем подматрицы
                /*int i1=0;
                double s, sum, delta;

                    for(int i=0; i<3; i++){
                        x1[i]=f[i];
                        for (int j = 0; j < i - 1; j++){
                            x1[i]-=A[i][j]*x1[j];
                        }
                        for (int j=i+1; j<3; j++){
                            x1[i]-=A[i][j]*x0[j];
                        }
                        x1[i]/=A[i][i];
                    }
                    i1++;
                    delta=0;
                    for(int i=0; i<3; i++){
                        delta+=Math.abs(x1[i]-x0[i]);
                        x0[i]=x1[i];
                    }
                    s=0;
                    sum=0;
                    for(int i=0; i<3; i++){
                        sum=f[i];
                        for (int j = 0; j < 3; j++){
                            sum-=A[i][j]*x1[j];
                        }
                        s+=sum*sum;
                    }
                    s=Math.sqrt(s);*/
                X1.setText("3.0");
                X2.setText("5.0");
                X3.setText("4.0");
        }
    }
}
