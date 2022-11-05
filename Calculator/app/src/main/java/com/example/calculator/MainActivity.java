package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    String operator = "";
    String num1 ="";
    Boolean isOp = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = findViewById(R.id.textView);
    }

    public void clear(){

        result.setText("");


    }

    public void cClick(View view){

        result.setText("");
        operator = "";
        num1 ="";
        isOp = false;


    }

    public void ClickFunc(View view) {

        if (view instanceof Button){

            Button button = (Button) view;

            String str = button.getText().toString();

            result.append(str);


        }


    }

    public void opClick(View view) {

        if(!isOp){


            Button button = (Button) view;

            operator = button.getText().toString();

            num1 = result.getText().toString();

            clear();
        }

        isOp = true;

    }

    public void equalClick(View view){

        if(isOp) {

            String num2 = result.getText().toString();

            Double ans = 0.0;

            switch (operator) {

                case "+":
                    ans = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case "-":
                    ans = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case "*":
                    ans = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case "/":
                    ans = Double.parseDouble(num1) / Double.parseDouble(num2);
                    break;

            }

            result.setText(String.valueOf(ans));

            isOp = false;
            num1 = "";

        }


    }
}