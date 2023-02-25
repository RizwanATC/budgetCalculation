package com.example.wallet_apps;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class activityBudgetCalculation extends AppCompatActivity {
    Dialog dialog;
    TextView chooseBudget,netSalary,calKeperluan,calKemahuan,calSimpanan,perKeperluan,perkemahuan,perSimpanan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_calc);

        chooseBudget = findViewById(R.id.tv_budget);
        dialog = new Dialog(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String getNetsalary = extras.getString("netSalary");
            netSalary = findViewById(R.id.tv_netSalary);
            netSalary.setText(getNetsalary);

            //The key argument here must match that used in the other activity
        }






        chooseBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFormulaDialog();
            }
        });





        /*monthList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                chooseBudget.setText(adapter.getItem(i));
                LinearLayout lyCustom = findViewById(R.id.ly_Custom);

                switch(i) {
                    case 0:
                        lyCustom.setVisibility(View.GONE);
                        break;
                    case 1:
                        lyCustom.setVisibility(View.GONE);
                        break;
                    case 2:
                        lyCustom.setVisibility(View.VISIBLE);
                        break;
                    default:
                        lyCustom.setVisibility(View.GONE);
                        break;
                }

                dialog.dismiss();
            }
        });*/


    }

    public void showFormulaDialog(){
        dialog.setContentView(R.layout.dialog_formula_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //init button
        ImageView closeButton = dialog.findViewById(R.id.btn_close);
        TextView formula1 = dialog.findViewById(R.id.btn_formula1);
        TextView formula2 = dialog.findViewById(R.id.btn_formula2);
        TextView custom = dialog.findViewById(R.id.btn_formula3);



        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        formula1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=formula1.getText().toString();
                chooseBudget.setText(s1);
                LinearLayout lyCustom = findViewById(R.id.ly_Custom);
                lyCustom.setVisibility(View.GONE);
                dialog.dismiss();
                String number  = s1.replaceAll("[^0-9]", "");
                String longString = number;
                String digit1String = longString.substring(0, 1); // Extract the first digit as a string
                String digit2String = longString.substring(1, 2);
                String digit3String = longString.substring(2, 3);
                String digit4String = longString.substring(3, 4);
                String digit5String = longString.substring(4, 5);
                String digit6String = longString.substring(5, 6);// Extract the second digit as a string
                    // Convert the second digit to an int
                String firstDigit = digit1String+digit2String;
                String secDigit = digit3String+digit4String;
                String thirdDigit = digit5String+digit6String;

                double first = Double.parseDouble(firstDigit);
                double second = Double.parseDouble(secDigit);
                double third = Double.parseDouble(thirdDigit);


                String replaceNet  = netSalary.getText().toString().replaceAll("[^0-9]", "");
                String netReplace = replaceNet;
                int conVnetSalary = Integer.parseInt(netReplace);
                double decimalSalary = conVnetSalary / 10.0; // Divide by 100.0 to move the decimal point two places to the left
                DecimalFormat df = new DecimalFormat("0.00");
                String frSalary = df.format(decimalSalary);

                double netSalaryConv = Double.parseDouble(String.valueOf(frSalary));

                double calculationKem = first*netSalaryConv/100;
                double calculationkep = second*netSalaryConv/100;
                double calculationSimp = third*netSalaryConv/100;

                calKeperluan = findViewById(R.id.tv_calCkemahuan);
                calKemahuan = findViewById(R.id.tv_calCKeperluann);
                calSimpanan = findViewById(R.id.tv_calsimpanan);

                String strcalKeperluan = String.format(String.valueOf(calculationKem));
                String strcalKemahuan = String.format(String.valueOf(calculationkep));
                String strcalSimpanan = String.format(String.valueOf(calculationSimp));
                calKeperluan.setText("Rm : "+strcalKemahuan);
                calKemahuan.setText("Rm : "+strcalKeperluan);
                calSimpanan.setText("Rm : "+strcalSimpanan);


                perKeperluan = findViewById(R.id.tv_percKeperluan);
                perkemahuan = findViewById(R.id.tv_percKemahuan);
                perSimpanan = findViewById(R.id.tv_percSimpanan);

                double strperKeperluan = Double.parseDouble(firstDigit);
                double strperkemahuan = Double.parseDouble(secDigit);
                double strperSimpanan= Double.parseDouble(thirdDigit);

                perKeperluan.setText(strperKeperluan+"%");
                perkemahuan.setText(strperkemahuan+"%");
                perSimpanan.setText(strperSimpanan+"%");



            }
        });
        formula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s2=formula2.getText().toString();
                chooseBudget.setText(s2);
                LinearLayout lyCustom = findViewById(R.id.ly_Custom);
                lyCustom.setVisibility(View.GONE);
                dialog.dismiss();
                String number  = s2.replaceAll("[^0-9]", "");
                String longString = number;
                String digit1String = longString.substring(0, 1); // Extract the first digit as a string
                String digit2String = longString.substring(1, 2);
                String digit3String = longString.substring(2, 3);
                String digit4String = longString.substring(3, 4);
                String digit5String = longString.substring(4, 5);
                String digit6String = longString.substring(5, 6);// Extract the second digit as a string
                // Convert the second digit to an int
                String firstDigit = digit1String+digit2String;
                String secDigit = digit3String+digit4String;
                String thirdDigit = digit5String+digit6String;

                double first = Double.parseDouble(firstDigit);
                double second = Double.parseDouble(secDigit);
                double third = Double.parseDouble(thirdDigit);


                String replaceNet  = netSalary.getText().toString().replaceAll("[^0-9]", "");
                String netReplace = replaceNet;
                int conVnetSalary = Integer.parseInt(netReplace);
                double decimalSalary = conVnetSalary / 10.0; // Divide by 100.0 to move the decimal point two places to the left
                DecimalFormat df = new DecimalFormat("0.00");
                String frSalary = df.format(decimalSalary);

                double netSalaryConv = Double.parseDouble(String.valueOf(frSalary));

                double calculationKem = first*netSalaryConv/100;
                double calculationkep = second*netSalaryConv/100;
                double calculationSimp = third*netSalaryConv/100;

                calKeperluan = findViewById(R.id.tv_calCkemahuan);
                calKemahuan = findViewById(R.id.tv_calCKeperluann);
                calSimpanan = findViewById(R.id.tv_calsimpanan);

                String strcalKeperluan = String.format("%.2f", calculationKem);
                String strcalKemahuan = String.format("%.2f", calculationkep);
                String strcalSimpanan = String.format("%.2f", calculationSimp);
                calKeperluan.setText("Rm : "+strcalKemahuan);
                calKemahuan.setText("Rm : "+strcalKeperluan);
                calSimpanan.setText("Rm : "+strcalSimpanan);


                perKeperluan = findViewById(R.id.tv_percKeperluan);
                perkemahuan = findViewById(R.id.tv_percKemahuan);
                perSimpanan = findViewById(R.id.tv_percSimpanan);

                double strperKeperluan = Double.parseDouble(firstDigit);
                double strperkemahuan = Double.parseDouble(secDigit);
                double strperSimpanan= Double.parseDouble(thirdDigit);

                perKeperluan.setText(strperKeperluan+"%");
                perkemahuan.setText(strperkemahuan+"%");
                perSimpanan.setText(strperSimpanan+"%");



            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 =custom.getText().toString();
                chooseBudget.setText(s1);
                LinearLayout lyCustom = findViewById(R.id.ly_Custom);
                lyCustom.setVisibility(View.VISIBLE);
                dialog.dismiss();

            }
        });
        dialog.show();
    }
}
