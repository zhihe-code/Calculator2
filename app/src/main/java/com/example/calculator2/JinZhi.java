package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JinZhi extends AppCompatActivity implements  View.OnClickListener{
    private Button but_0;
    private Button but_1;
    private Button but_2;
    private Button but_3;
    private Button but_4;
    private Button but_5;
    private Button but_6;
    private Button but_7;
    private Button but_8;
    private Button but_9;
    private Button but_a;
    private Button but_b;
    private Button but_c;
    private Button but_d;
    private Button but_e;
    private Button but_f;
    private EditText two_edit;
    private EditText ten_edit;
    private EditText eight_edit;
    private EditText sixteen_edit;


    //文本框空标记
    boolean clean=true;
    int jin_zhi=16;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_zhi);
        but_0=findViewById(R.id.but_0);
        but_1=findViewById(R.id.but_1);
        but_2=findViewById(R.id.but_2);
        but_3=findViewById(R.id.but_3);
        but_4=findViewById(R.id.but_4);
        but_5=findViewById(R.id.but_5);
        but_6=findViewById(R.id.but_6);
        but_7=findViewById(R.id.but_7);
        but_8=findViewById(R.id.but_8);
        but_9=findViewById(R.id.but_9);
        but_a=findViewById(R.id.but_a);
        but_b=findViewById(R.id.but_b);
        but_c=findViewById(R.id.but_c);
        but_d=findViewById(R.id.but_d);
        but_e=findViewById(R.id.but_e);
        but_f=findViewById(R.id.but_f);

        two_edit=findViewById(R.id.two_edit);
        ten_edit=findViewById(R.id.ten_edit);
        eight_edit=findViewById(R.id.eight_edit);
        sixteen_edit=findViewById(R.id.sixteen_edit);

        //        光标显示但不召出软键盘
        two_edit.setShowSoftInputOnFocus(false);
        ten_edit.setShowSoftInputOnFocus(false);
        eight_edit.setShowSoftInputOnFocus(false);
        sixteen_edit.setShowSoftInputOnFocus(false);

        but_0.setOnClickListener(this);
        but_1.setOnClickListener(this);
        but_2.setOnClickListener(this);
        but_3.setOnClickListener(this);
        but_4.setOnClickListener(this);
        but_5.setOnClickListener(this);
        but_6.setOnClickListener(this);
        but_7.setOnClickListener(this);
        but_8.setOnClickListener(this);
        but_9.setOnClickListener(this);
        but_a.setOnClickListener(this);
        but_b.setOnClickListener(this);
        but_c.setOnClickListener(this);
        but_d.setOnClickListener(this);
        but_e.setOnClickListener(this);
        but_f.setOnClickListener(this);
        two_edit.setOnClickListener(this);
        ten_edit.setOnClickListener(this);
        eight_edit.setOnClickListener(this);
        sixteen_edit.setOnClickListener(this);




        two_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                jin_zhi=2;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(false);
                but_3.setEnabled(false);
                but_4.setEnabled(false);
                but_5.setEnabled(false);
                but_6.setEnabled(false);
                but_7.setEnabled(false);
                but_8.setEnabled(false);
                but_9.setEnabled(false);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        eight_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                jin_zhi=8;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(false);
                but_9.setEnabled(false);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        ten_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                jin_zhi=10;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                return false;
            }
        });
        sixteen_edit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                jin_zhi=16;
                but_0.setEnabled(true);
                but_1.setEnabled(true);
                but_2.setEnabled(true);
                but_3.setEnabled(true);
                but_4.setEnabled(true);
                but_5.setEnabled(true);
                but_6.setEnabled(true);
                but_7.setEnabled(true);
                but_8.setEnabled(true);
                but_9.setEnabled(true);
                but_a.setEnabled(true);
                but_b.setEnabled(true);
                but_c.setEnabled(true);
                but_d.setEnabled(true);
                but_e.setEnabled(true);
                but_f.setEnabled(true);
                return false;
            }
        });




    }


    @Override
    public void onClick(View view) {
        String str="";
        int value=0;
        switch (view.getId()){
            case R.id.but_0:
            case R.id.but_1:
            case R.id.but_2:
            case R.id.but_3:
            case R.id.but_4:
            case R.id.but_5:
            case R.id.but_6:
            case R.id.but_7:
            case R.id.but_8:
            case R.id.but_9:
            case R.id.but_a:
            case R.id.but_b:
            case R.id.but_c:
            case R.id.but_d:
            case R.id.but_e:
            case R.id.but_f:
                if (clean) {
                    clean = false;
                }
                try {
                    if(jin_zhi==2){
                        str=two_edit.getText().toString();
                        two_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Integer.parseInt(two_edit.getText().toString(),2);
                        sixteen_edit.setText(Integer.toHexString(value));
                        ten_edit.setText(Integer.toString(value));
                        eight_edit.setText(Integer.toOctalString(value));
                        two_edit.setSelection(two_edit.getText().length());
                        two_edit.getSelectionEnd();
                        break;
                    }
                    else if(jin_zhi==10){
                        str=ten_edit.getText().toString();
                        ten_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Integer.parseInt(ten_edit.getText().toString());
                        sixteen_edit.setText(Integer.toHexString(value));
                        two_edit.setText(Integer.toBinaryString(value));
                        eight_edit.setText(Integer.toOctalString(value));
                        ten_edit.setSelection(ten_edit.getText().length());
                        ten_edit.getSelectionEnd();
                        break;
                    }
                    else if(jin_zhi==8){
                        str=eight_edit.getText().toString();
                        eight_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Integer.parseInt(eight_edit.getText().toString(),8);
                        sixteen_edit.setText(Integer.toHexString(value));
                        ten_edit.setText(Integer.toString(value));
                        two_edit.setText(Integer.toBinaryString(value));
                        eight_edit.setSelection(eight_edit.getText().length());
                        eight_edit.getSelectionEnd();
                        break;
                    }
                    else if(jin_zhi==16){
                        str=sixteen_edit.getText().toString();
                        sixteen_edit.setText(str + ((Button) view).getText().toString() + "");
                        value = Integer.parseInt(sixteen_edit.getText().toString(),16);
                        ten_edit.setText(Integer.toString(value));
                        two_edit.setText(Integer.toBinaryString(value));
                        eight_edit.setText(Integer.toOctalString(value));
                        sixteen_edit.setSelection(sixteen_edit.getText().length());
                        sixteen_edit.getSelectionEnd();
                        break;
                    }
                    break;

                }catch (Exception e){

                }

            case R.id.clean_all:
                if (!clean) {
                    two_edit.setText("");
                    eight_edit.setText("");
                    ten_edit.setText("");
                    sixteen_edit.setText("");
                    clean = true;
                    break;
                }
                break;
            case R.id.backspace:
                if (!clean) {
                    try{
                        if (jin_zhi == 2) {
                            str=two_edit.getText().toString();
                            str=str.substring(0,two_edit.getText().length()-1);
                            two_edit.setText(str + "");
                            value = Integer.parseInt(two_edit.getText().toString(),2);
                            sixteen_edit.setText(Integer.toHexString(value));
                            ten_edit.setText(Integer.toString(value));
                            eight_edit.setText(Integer.toOctalString(value));
                            two_edit.setSelection(two_edit.getText().length());
                            two_edit.getSelectionEnd();
                        }
                        else if (jin_zhi == 8) {
                            str=eight_edit.getText().toString();
                            str=str.substring(0,eight_edit.getText().length()-1);
                            eight_edit.setText(str + "");
                            value = Integer.parseInt(eight_edit.getText().toString(),8);
                            sixteen_edit.setText(Integer.toHexString(value));
                            ten_edit.setText(Integer.toString(value));
                            two_edit.setText(Integer.toHexString(value));
                            eight_edit.setSelection(eight_edit.getText().length());
                            eight_edit.getSelectionEnd();
                        }
                        else if (jin_zhi == 10) {
                            str=ten_edit.getText().toString();
                            str=str.substring(0,ten_edit.getText().length()-1);
                            ten_edit.setText(str + "");
                            value = Integer.parseInt(ten_edit.getText().toString());
                            sixteen_edit.setText(Integer.toHexString(value));
                            two_edit.setText(Integer.toBinaryString(value));
                            eight_edit.setText(Integer.toOctalString(value));
                            ten_edit.setSelection(ten_edit.getText().length());
                            ten_edit.getSelectionEnd();
                        }
                        else if (jin_zhi == 16) {
                            str=sixteen_edit.getText().toString();
                            str=str.substring(0,sixteen_edit.getText().length()-1);
                            sixteen_edit.setText(str + "");
                            value = Integer.parseInt(sixteen_edit.getText().toString(),16);
                            ten_edit.setText(Integer.toString(value));
                            two_edit.setText(Integer.toBinaryString(value));
                            eight_edit.setText(Integer.toOctalString(value));
                            sixteen_edit.setSelection(sixteen_edit.getText().length());
                            sixteen_edit.getSelectionEnd();
                        }

                    }catch (Exception e) {

                    }
                    if (str.equals("")) {
                        clean = true;
                        two_edit.setText("");
                        eight_edit.setText("");
                        ten_edit.setText("");
                        sixteen_edit.setText("");
                        break;
                    }
                    break;

                }

            }

        }
}



