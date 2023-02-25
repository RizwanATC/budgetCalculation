package com.example.wallet_apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                double socsoCalculation =0.49*calCGross/100;
                double eisCalculation = 0.19*calCGross/100;
                double taxCalculation = 90;
                double netSalary  = calCGross - epfCalculation-socsoCalculation-eisCalculation-taxCalculation;




                salaryNet.setText("Rm: "+netSalary);
                epf.setText("Rm: "+epfCalculation);
                socso.setText("Rm: "+socsoCalculation);
                eis.setText("Rm: "+eisCalculation);
                tax.setText("Rm: "+taxCalculation);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String netSalary = String.valueOf(salaryNet.getText());
                Intent intent = new Intent(MainActivity.this, activityBudgetCalculation.class);
                intent.putExtra("netSalary",netSalary);
                startActivity(intent);
            }
        });




    }


}