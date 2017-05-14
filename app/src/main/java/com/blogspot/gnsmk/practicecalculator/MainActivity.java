package com.blogspot.gnsmk.practicecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView tvResult;
    EditText etFirstNum, etSecondNum;
    String num1, num2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNum = (EditText) findViewById(R.id.etEnterFirstNumber);
        etSecondNum = (EditText) findViewById(R.id.etEnterSecondNumber);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    public void operation(View view) {
        if (!isEqual(num1 = etFirstNum.getText().toString(), "") && !isEqual(num2 = etSecondNum.getText().toString(), "")) {
            switch (view.getId()) {
                case R.id.btnAdd:
                    setOutput(Double.parseDouble(num1) + Double.parseDouble(num2));
                    break;
                case R.id.btnSub:
                    setOutput(Double.parseDouble(num1) - Double.parseDouble(num2));
                    break;
                case R.id.btnMul:
                    setOutput(Double.parseDouble(num1) * Double.parseDouble(num2));
                    break;
                case R.id.btnDiv:
                    setOutput(Double.parseDouble(num1) / Double.parseDouble(num2));
                    break;
                case R.id.btnClear:
                    tvResult.setText("");
                    etFirstNum.getText().clear();
                    etSecondNum.getText().clear();
                    break;
            }
        } else {
            tvResult.setText("please enter some values");
        }
    }

    public void setOutput(double d) {
        if ((int) d == d) {
            tvResult.setText(String.valueOf((int) d));
        } else {
            tvResult.setText(String.valueOf(d));
        }
    }

    public boolean isEqual(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}