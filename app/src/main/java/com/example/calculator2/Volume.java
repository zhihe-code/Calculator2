package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class Volume extends AppCompatActivity implements  View.OnClickListener{
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
    private EditText m_edit;
    private EditText dm_edit;
    private EditText cm_edit;
    private EditText mm_edit;
    private EditText l_edit;
    private EditText ml_edit;


    //文本框空标记
    boolean clean=true;
    int volume=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
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
        m_edit=findViewById(R.id.m_edit);
        dm_edit=findViewById(R.id.dm_edit);
        cm_edit=findViewById(R.id.cm_edit);
        mm_edit=findViewById(R.id.mm_edit);
        l_edit=findViewById(R.id.l_edit);
        ml_edit=findViewById(R.id.ml_edit);

        //        光标显示但不召出软键盘
        m_edit.setShowSoftInputOnFocus(false);
        dm_edit.setShowSoftInputOnFocus(false);
        cm_edit.setShowSoftInputOnFocus(false);
        mm_edit.setShowSoftInputOnFocus(false);
        l_edit.setShowSoftInputOnFocus(false);
        ml_edit.setShowSoftInputOnFocus(false);

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

        m_edit.setOnClickListener(this);
        dm_edit.setOnClickListener(this);
        cm_edit.setOnClickListener(this);
        mm_edit.setOnClickListener(this);
        l_edit.setOnClickListener(this);
        ml_edit.setOnClickListener(this);




        m_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=1;

                return false;
            }
        });
        dm_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=2;

                return false;
            }
        });
        cm_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=3;

                return false;
            }
        });
        mm_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=4;

                return false;
            }
        });
        l_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=5;

                return false;
            }
        });
        ml_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                volume=6;

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
                    if(volume==1){
                        str=m_edit.getText().toString();
                        m_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(m_edit.getText().toString());
                        dm_edit.setText(Double.toString(value*1000));
                        cm_edit.setText(Double.toString(value*1000*1000));
                        mm_edit.setText(Double.toString(value*1000*1000*1000));
                        l_edit.setText(Double.toString(value*1000));
                        ml_edit.setText(Double.toString(value*1000*1000));
                        m_edit.setSelection(m_edit.getText().length());
                        m_edit.getSelectionEnd();
                        break;
                    }
                    if(volume==2){
                        str=dm_edit.getText().toString();
                        dm_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(dm_edit.getText().toString());
                        m_edit.setText(Double.toString(value*0.001));
                        cm_edit.setText(Double.toString(value*1000));
                        mm_edit.setText(Double.toString(value*1000*1000));
                        l_edit.setText(Double.toString(value));
                        ml_edit.setText(Double.toString(value*1000));
                        dm_edit.setSelection(dm_edit.getText().length());
                        dm_edit.getSelectionEnd();
                        break;
                    }
                    if(volume==3){
                        str=cm_edit.getText().toString();
                        cm_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(cm_edit.getText().toString());
                        dm_edit.setText(Double.toString(value*0.001));
                        m_edit.setText(Double.toString(value*0.001*0.001));
                        mm_edit.setText(Double.toString(value*1000));
                        l_edit.setText(Double.toString(value*0.001));
                        ml_edit.setText(Double.toString(value));
                        cm_edit.setSelection(cm_edit.getText().length());
                        cm_edit.getSelectionEnd();
                        break;
                    }
                    if(volume==4){
                        str=mm_edit.getText().toString();
                        mm_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(mm_edit.getText().toString());
                        dm_edit.setText(Double.toString(value*0.001*0.001));
                        cm_edit.setText(Double.toString(value*0.001));
                        m_edit.setText(Double.toString(value*0.001*0.001*0.001));
                        l_edit.setText(Double.toString(value*0.001*0.001));
                        ml_edit.setText(Double.toString(value*0.001));
                        mm_edit.setSelection(mm_edit.getText().length());
                        mm_edit.getSelectionEnd();
                        break;
                    }
                    if(volume==5){
                        str=l_edit.getText().toString();
                        l_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(l_edit.getText().toString());
                        m_edit.setText(Double.toString(value*0.001));
                        cm_edit.setText(Double.toString(value*1000));
                        mm_edit.setText(Double.toString(value*1000*1000));
                        dm_edit.setText(Double.toString(value));
                        ml_edit.setText(Double.toString(value*1000));
                        l_edit.setSelection(l_edit.getText().length());
                        l_edit.getSelectionEnd();
                        break;
                    }
                    if(volume==6){
                        str=ml_edit.getText().toString();
                        ml_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Double.parseDouble(ml_edit.getText().toString());
                        dm_edit.setText(Double.toString(value*0.001));
                        m_edit.setText(Double.toString(value*0.001*0.001));
                        mm_edit.setText(Double.toString(value*1000));
                        l_edit.setText(Double.toString(value*0.001));
                        cm_edit.setText(Double.toString(value));
                        ml_edit.setSelection(ml_edit.getText().length());
                        ml_edit.getSelectionEnd();
                        break;
                    }
                    break;

                }catch (Exception e){

                }

            case R.id.clean_all:
                if (!clean) {
                    m_edit.setText("");
                    dm_edit.setText("");
                    cm_edit.setText("");
                    mm_edit.setText("");
                    l_edit.setText("");
                    ml_edit.setText("");
                    clean = true;
                    break;
                }
                break;

        }

    }
}



