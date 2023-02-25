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

import java.util.ArrayList;
import java.util.List;

public class activityBudgetCalculation extends AppCompatActivity {
    Dialog dialog;
    TextView chooseBudget,netSalary;

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

            }
        });
        formula2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=formula2.getText().toString();
                chooseBudget.setText(s1);
                LinearLayout lyCustom = findViewById(R.id.ly_Custom);
                lyCustom.setVisibility(View.GONE);
                dialog.dismiss();

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
