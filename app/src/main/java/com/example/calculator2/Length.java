package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class Length extends AppCompatActivity implements  View.OnClickListener{
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
    private EditText mi_edit;
    private EditText kmi_edit;
    private EditText limi_edit;
    private EditText haomi_edit;
    private EditText fenmi_edit;
    private EditText weimi_edit;
    private EditText nami_edit;


    //文本框空标记
    boolean clean=true;
    int length=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
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
        mi_edit=findViewById(R.id.mi_edit);
        kmi_edit=findViewById(R.id.kmi_edit);
        fenmi_edit=findViewById(R.id.fenmi_edit);
        limi_edit=findViewById(R.id.limi_edit);
        haomi_edit=findViewById(R.id.haomi_edit);
        weimi_edit=findViewById(R.id.weimi_edit);
        nami_edit=findViewById(R.id.nami_edit);

        //        光标显示但不召出软键盘
        mi_edit.setShowSoftInputOnFocus(false);
        kmi_edit.setShowSoftInputOnFocus(false);
        fenmi_edit.setShowSoftInputOnFocus(false);
        limi_edit.setShowSoftInputOnFocus(false);
        haomi_edit.setShowSoftInputOnFocus(false);
        weimi_edit.setShowSoftInputOnFocus(false);
        nami_edit.setShowSoftInputOnFocus(false);

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

        mi_edit.setOnClickListener(this);
        kmi_edit.setOnClickListener(this);
        fenmi_edit.setOnClickListener(this);
        limi_edit.setOnClickListener(this);
        haomi_edit.setOnClickListener(this);
        weimi_edit.setOnClickListener(this);
        nami_edit.setOnClickListener(this);




        mi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=1;

                return false;
            }
        });
        kmi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=2;

                return false;
            }
        });
        fenmi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=3;

                return false;
            }
        });
        limi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=4;

                return false;
            }
        });
        haomi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=5;

                return false;
            }
        });
        weimi_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=6;

                return false;
            }
        });
        nami_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                length=7;

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
                    if(length==1){
                        str=mi_edit.getText().toString();
                        mi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(mi_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001));
                        fenmi_edit.setText(Double.toString(value*10));
                        limi_edit.setText(Double.toString(value*100));
                        haomi_edit.setText(Double.toString(value*1000));
                        weimi_edit.setText(Double.toString(value*1000*1000));
                        nami_edit.setText(Double.toString(value*1000*1000*1000));
                        mi_edit.setSelection(mi_edit.getText().length());
                        mi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==2){
                        str=kmi_edit.getText().toString();
                        kmi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(kmi_edit.getText().toString());
                        mi_edit.setText(Double.toString(value*1000));
                        fenmi_edit.setText(Double.toString(value*10*1000));
                        limi_edit.setText(Double.toString(value*100*1000));
                        haomi_edit.setText(Double.toString(value*1000*1000));
                        weimi_edit.setText(Double.toString(value*1000*1000*1000));
                        nami_edit.setText(Double.toString(value*1000*1000*1000*1000));
                        kmi_edit.setSelection(kmi_edit.getText().length());
                        kmi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==3){
                        str=fenmi_edit.getText().toString();
                        fenmi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(fenmi_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001*0.001));
                        mi_edit.setText(Double.toString(value*0.1));
                        limi_edit.setText(Double.toString(value*10));
                        haomi_edit.setText(Double.toString(value*100));
                        weimi_edit.setText(Double.toString(value*1000*100));
                        nami_edit.setText(Double.toString(value*1000*1000*100));
                        fenmi_edit.setSelection(fenmi_edit.getText().length());
                        fenmi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==4){
                        str=limi_edit.getText().toString();
                        limi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(limi_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001*0.01));
                        fenmi_edit.setText(Double.toString(value*0.1));
                        mi_edit.setText(Double.toString(value*0.01));
                        haomi_edit.setText(Double.toString(value*10));
                        weimi_edit.setText(Double.toString(value*10*1000));
                        nami_edit.setText(Double.toString(value*10*1000*1000));
                        limi_edit.setSelection(limi_edit.getText().length());
                        limi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==5){
                        str=haomi_edit.getText().toString();
                        haomi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(haomi_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001*0.001));
                        fenmi_edit.setText(Double.toString(value*0.01));
                        limi_edit.setText(Double.toString(value*0.1));
                        mi_edit.setText(Double.toString(value*0.001));
                        weimi_edit.setText(Double.toString(value*1000));
                        nami_edit.setText(Double.toString(value*1000*1000));
                        haomi_edit.setSelection(haomi_edit.getText().length());
                        haomi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==6){
                        str=weimi_edit.getText().toString();
                        weimi_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(weimi_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001*0.001*0.001));
                        fenmi_edit.setText(Double.toString(value*0.001*0.01));
                        limi_edit.setText(Double.toString(value*0.001*0.1));
                        haomi_edit.setText(Double.toString(value*0.001));
                        mi_edit.setText(Double.toString(value*0.001*0.001));
                        nami_edit.setText(Double.toString(value*1000));
                        weimi_edit.setSelection(weimi_edit.getText().length());
                        weimi_edit.getSelectionEnd();
                        break;
                    }
                    if(length==7){
                        str=nami_edit.getText().toString();
                        nami_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(nami_edit.getText().toString());
                        kmi_edit.setText(Double.toString(value*0.001*0.001*0.001*0.001));
                        fenmi_edit.setText(Double.toString(value*0.001*0.001*0.01));
                        limi_edit.setText(Double.toString(value*0.001*0.001*0.1));
                        haomi_edit.setText(Double.toString(value*0.001*0.001));
                        weimi_edit.setText(Double.toString(value*0.001));
                        mi_edit.setText(Double.toString(value*0.001*0.001*0.001));
                        nami_edit.setSelection(nami_edit.getText().length());
                        nami_edit.getSelectionEnd();
                        break;
                    }
                    break;

                }catch (Exception e){

                }

            case R.id.clean_all:
                if (!clean) {
                    mi_edit.setText("");
                    kmi_edit.setText("");
                    fenmi_edit.setText("");
                    limi_edit.setText("");
                    haomi_edit.setText("");
                    weimi_edit.setText("");
                    nami_edit.setText("");
                    clean = true;
                    break;
                }
                break;

        }

    }
}



