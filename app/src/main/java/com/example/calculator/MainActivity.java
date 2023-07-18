package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText edResult;
    String op="+",oldNum;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edResult = findViewById(R.id.result);
    }
    @SuppressLint("NonConstantResourceId")
    public void numberEvent(View view){
        if(i==0)
           edResult.setText("");
        String num= edResult.getText().toString();
       /* switch(view.getId()){
            case R.id.b0: num +="0"; break;
            case R.id.b1: num +="1"; break;
            case R.id.b2: num +="2"; break;
            case R.id.b3: num +="3"; break;
            case R.id.b4: num +="4"; break;
            case R.id.b5: num +="5"; break;
            case R.id.b6: num +="6"; break;
            case R.id.b7: num +="7"; break;
            case R.id.b8: num +="8"; break;
            case R.id.b9: num +="9"; break;

        }*/

        if (view.getId() == R.id.b0) {
            num += "0";
        } else if (view.getId() == R.id.b1) {
            num += "1";
        } else if (view.getId() == R.id.b2) {
            num += "2";
        } else if (view.getId() == R.id.b3) {
            num += "3";
        } else if (view.getId() == R.id.b4) {
            num += "4";
        } else if (view.getId() == R.id.b5) {
            num += "5";
        } else if (view.getId() == R.id.b6) {
            num += "6";
        } else if (view.getId() == R.id.b7) {
            num += "7";
        } else if (view.getId() == R.id.b8) {
            num += "8";
        } else if (view.getId() == R.id.b9) {
            num += "9";
        }
        i++;
        edResult.setText(num);

    }
    public void operationEvent(View view)
    {
        oldNum=edResult.getText().toString();
        if(view.getId()==R.id.bAdd)
            op = "+";
        else if(view.getId()==R.id.bSub)
            op = "-";
        else if(view.getId()==R.id.bDiv)
            op = "/";
        else if(view.getId()==R.id.bMul)
            op = "*";
        i=0;
        edResult.getText().clear();

    }
    public void assignEvent(View view)
    {

         String newNum = edResult.getText().toString();
         double res=0.0;
         switch (op){
             case "+": res =Double.parseDouble(oldNum)+ Double.parseDouble(newNum); break;
             case "-": res =Double.parseDouble(oldNum)- Double.parseDouble(newNum); break;
             case "*": res =Double.parseDouble(oldNum)* Double.parseDouble(newNum); break;
             case "/": res =Double.parseDouble(oldNum)/ Double.parseDouble(newNum); break;
         }
         edResult.setText("="+res);
         i=0;

    }
    public void clearEvent(View view)
    {
          i=0;
          edResult.setText("0");
    }


    public void delEvent(View view) {
        String data = edResult.getText().toString();
        if (data.length() > 0) {
            String val = data.substring(0, data.length() - 1);
            edResult.setText(val);
        } else {
            edResult.setText("0");
        }
    }

}