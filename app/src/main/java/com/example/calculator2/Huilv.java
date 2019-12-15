package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class Huilv extends AppCompatActivity implements  View.OnClickListener{
    private Button number0;
    private Button number1;
    private Button number2;
    private Button number3;
    private Button number4;
    private Button number5;
    private Button number6;
    private Button number7;
    private Button number8;
    private Button number9;
    private Button dot;
    private Button clean_all;
    private EditText usd_edit;
    private EditText cny_edit;
    private EditText hkd_edit;
    private EditText gbp_edit;
    private EditText eur_edit;
    private EditText jpy_edit;

    //文本框空标记
    boolean clean=true;
    int money=2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        number0=findViewById(R.id.number0);
        number1=findViewById(R.id.number1);
        number2=findViewById(R.id.number2);
        number3=findViewById(R.id.number3);
        number4=findViewById(R.id.number4);
        number5=findViewById(R.id.number5);
        number6=findViewById(R.id.number6);
        number7=findViewById(R.id.number7);
        number8=findViewById(R.id.number8);
        number9=findViewById(R.id.number9);
        dot=findViewById(R.id.dot);
        clean_all=findViewById(R.id.clean_all);
        usd_edit=findViewById(R.id.usd_edit);
        cny_edit=findViewById(R.id.cny_edit);
        hkd_edit=findViewById(R.id.hkd_edit);
        gbp_edit=findViewById(R.id.gbp_edit);
        eur_edit=findViewById(R.id.eur_edit);
        jpy_edit=findViewById(R.id.jpy_edit);

        //        光标显示但不召出软键盘
        usd_edit.setShowSoftInputOnFocus(false);
        cny_edit.setShowSoftInputOnFocus(false);
        hkd_edit.setShowSoftInputOnFocus(false);
        gbp_edit.setShowSoftInputOnFocus(false);
        eur_edit.setShowSoftInputOnFocus(false);
        jpy_edit.setShowSoftInputOnFocus(false);

        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        dot.setOnClickListener(this);
        clean_all.setOnClickListener(this);

        usd_edit.setOnClickListener(this);
        cny_edit.setOnClickListener(this);
        hkd_edit.setOnClickListener(this);
        gbp_edit.setOnClickListener(this);
        eur_edit.setOnClickListener(this);
        jpy_edit.setOnClickListener(this);




        usd_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=1;

                return false;
            }
        });
        cny_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=2;

                return false;
            }
        });
        hkd_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=3;

                return false;
            }
        });
        gbp_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=4;

                return false;
            }
        });
        eur_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=5;

                return false;
            }
        });
        jpy_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                money=6;

                return false;
            }
        });




    }


    @Override
    public void onClick(View view) {
        String str="";
        double value=0.0;
        DecimalFormat decimalFormat = new DecimalFormat();
        switch (view.getId()){
            case R.id.number0:
            case R.id.number1:
            case R.id.number2:
            case R.id.number3:
            case R.id.number4:
            case R.id.number5:
            case R.id.number6:
            case R.id.number7:
            case R.id.number8:
            case R.id.number9:
            case R.id.dot:
                if (clean) {
                    clean = false;
                }
                try {
                    if(money==1){
                        str=usd_edit.getText().toString();
                        usd_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(usd_edit.getText().toString());
                        cny_edit.setText(Double.toString(value*7.04));
                        hkd_edit.setText(Double.toString(value*7.82));
                        gbp_edit.setText(Double.toString(value*0.78));
                        eur_edit.setText(Double.toString(value*0.91));
                        jpy_edit.setText(Double.toString(value*108.62));
                        usd_edit.setSelection(usd_edit.getText().length());
                        usd_edit.getSelectionEnd();
                        break;
                    }
                    if(money==2){
                        str=cny_edit.getText().toString();
                        cny_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(cny_edit.getText().toString());
                        usd_edit.setText(Double.toString(value*0.14));
                        hkd_edit.setText(Double.toString(value*1.11));
                        gbp_edit.setText(Double.toString(value*0.11));
                        eur_edit.setText(Double.toString(value*0.13));
                        jpy_edit.setText(Double.toString(value*15.43));
                        cny_edit.setSelection(cny_edit.getText().length());
                        cny_edit.getSelectionEnd();
                        break;
                    }
                    if(money==3){
                        str=hkd_edit.getText().toString();
                        hkd_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(hkd_edit.getText().toString());
                        usd_edit.setText(Double.toString(value*0.13));
                        cny_edit.setText(Double.toString(value*0.9));
                        gbp_edit.setText(Double.toString(value*0.1));
                        eur_edit.setText(Double.toString(value*0.12));
                        jpy_edit.setText(Double.toString(value*13.88));
                        hkd_edit.setSelection(hkd_edit.getText().length());
                        hkd_edit.getSelectionEnd();
                        break;
                    }
                    if(money==4){
                        str=gbp_edit.getText().toString();
                        gbp_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(gbp_edit.getText().toString());
                        usd_edit.setText(Double.toString(value*1.28));
                        cny_edit.setText(Double.toString(value*9.04));
                        hkd_edit.setText(Double.toString(value*10.04));
                        eur_edit.setText(Double.toString(value*1.16));
                        jpy_edit.setText(Double.toString(value*139.44));
                        gbp_edit.setSelection(gbp_edit.getText().length());
                        gbp_edit.getSelectionEnd();
                        break;
                    }
                    if(money==5){
                        str=eur_edit.getText().toString();
                        eur_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(eur_edit.getText().toString());
                        usd_edit.setText(Double.toString(value*1.1));
                        cny_edit.setText(Double.toString(value*7.76));
                        hkd_edit.setText(Double.toString(value*8.62));
                        gbp_edit.setText(Double.toString(value*0.86));
                        jpy_edit.setText(Double.toString(value*119.72));
                        eur_edit.setSelection(eur_edit.getText().length());
                        eur_edit.getSelectionEnd();
                        break;
                    }
                    if(money==6){
                        str=jpy_edit.getText().toString();
                        jpy_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(jpy_edit.getText().toString());
                        usd_edit.setText(Double.toString(value*0.01));
                        cny_edit.setText(Double.toString(value*0.06));
                        hkd_edit.setText(Double.toString(value*0.07));
                        gbp_edit.setText(Double.toString(value*0.01));
                        eur_edit.setText(Double.toString(value*0.01));
                        jpy_edit.setSelection(jpy_edit.getText().length());
                        jpy_edit.getSelectionEnd();
                        break;
                    }
                    break;

                }catch (Exception e){

                }

            case R.id.clean_all:
                if (!clean) {
                    usd_edit.setText("");
                    cny_edit.setText("");
                    hkd_edit.setText("");
                    gbp_edit.setText("");
                    eur_edit.setText("");
                    jpy_edit.setText("");
                    clean = true;
                    break;
                }
                break;

        }

    }
}



