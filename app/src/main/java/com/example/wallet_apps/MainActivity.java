package com.example.wallet_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText gross ;
    Button calculate,next;
    TextView epf,socso,eis,tax,salaryNet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gross = findViewById(R.id.et_gross);
        calculate = findViewById(R.id.btn_calC);
        next = findViewById(R.id.btn_next);
        epf = findViewById(R.id.tv_epf);
        socso = findViewById(R.id.tv_socso);
        eis =findViewById(R.id.tv_eis);
        tax =findViewById(R.id.tv_tax);
        salaryNet = findViewById(R.id.tv_netSalary);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                double calCGross = Double.parseDouble(gross.getText().toString());
                double epfCalculation = 11*calCGross/100;
                double socsoCalculation =0.49444444444444*calCGross/100;
                double eisCalculation = 0.197*calCGross/100;
                double taxCalculation = 2*calCGross/100;

                double netSalary  = calCGross - epfCalculation-socsoCalculation-eisCalculation-taxCalculation;

                String epfConv = Double.toString(epfCalculation);
                String socConv = Double.toString(socsoCalculation);
                String eisConV = Double.toString(eisCalculation);
                String texConv = Double.toString(taxCalculation);
                String salConv = Double.toString(netSalary);

                DecimalFormat precision = new DecimalFormat("0.00");


                salaryNet.setText("Rm: "+precision.format(salConv));
                salaryNet.setText("Rm: "+precision.format(epfConv));
                salaryNet.setText("Rm: "+precision.format(socConv));
                salaryNet.setText("Rm: "+precision.format(eisConV));
                salaryNet.setText("Rm: "+precision.format(texConv));




            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, budgetCalculation.class);
                startActivity(intent);
            }
        });




    }


}