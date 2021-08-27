package com.example.calculator_starostina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNum1;
    EditText etNum2;

    Button btnSum;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // находим элементы
        etNum1 = (EditText) findViewById(R.id.numberField1);
        etNum2 = (EditText) findViewById(R.id.numberField2);

        btnSum = (Button) findViewById(R.id.key_sum);
        btnSub = (Button) findViewById(R.id.key_sub);
        btnMult = (Button) findViewById(R.id.key_mul);
        btnDiv = (Button) findViewById(R.id.key_div);

        tvResult = (TextView) findViewById(R.id.result);

        // прописываем обработчик
        btnSum.setOnClickListener((View.OnClickListener) this);
        btnSub.setOnClickListener((View.OnClickListener) this);
        btnMult.setOnClickListener((View.OnClickListener) this);
        btnDiv.setOnClickListener((View.OnClickListener) this);

    }

    public void onClick(View v) {

        float num1 = 0;
        float num2 = 0;
        float result = 0;


        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }


        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());


        switch (v.getId()) {
            case R.id.key_sum:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.key_sub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.key_mul:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.key_div:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
}

