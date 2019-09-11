package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;

public class Normal extends AppCompatActivity implements  View.OnClickListener{

//    private String[] KEYS = {number0,number1,number2,number3,number4,number5,number6,number7,number8,number9,
//                                dot,add,subtract,multi,division,precent,equal,plusorminus,memoryrecall,memoryminus,memoryclear,memoryplus,
//                                allclear,backspace,history,back,,editText,textView};
    //    数字0-9
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

    //    运算
    private Button add;
    private Button subtract;
    private Button multi;
    private Button division;
    private Button precent;
    private Button dot;
    private Button equal;
    private Button plusorminus;

    //    操作
    private Button memoryclear;
    private Button memoryplus;
    private Button memoryminus;
    private Button memoryrecall;
    private Button allclear;
    private Button backspace;

    //    历史记录
    private Button history;
    //    进制转换
    private Button back;

    //    输入结果
    private EditText editText;

    //    结果显示
    private TextView textView;

    boolean clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
//        全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        实例化
        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);

        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multi = findViewById(R.id.multi);
        division = findViewById(R.id.division);
        precent = findViewById(R.id.precent);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        plusorminus = findViewById(R.id.plusorminus);

        memoryclear = findViewById(R.id.memoryclear);
        memoryplus = findViewById(R.id.memoryplus);
        memoryminus = findViewById(R.id.memoryminus);
        memoryrecall = findViewById(R.id.memoryrecall);

        allclear = findViewById(R.id.allclear);
        backspace = findViewById(R.id.backspace);

        history = findViewById(R.id.history);
        back = findViewById(R.id.back);

        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);


//        设置按钮点击事件
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

        allclear.setOnClickListener(this);
        backspace.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multi.setOnClickListener(this);
        division.setOnClickListener(this);

        equal.setOnClickListener(this);
//        plusorminus.setOnClickListener(this);
//        memoryclear.setOnClickListener(this);
//        memoryplus.setOnClickListener(this);
//        memoryminus.setOnClickListener(this);
//        memoryrecall.setOnClickListener(this);

//        history.setOnClickListener(this);
//        back.setOnClickListener(this);


//        光标显示但不召出软键盘
        editText.setShowSoftInputOnFocus(false);



    }


    @Override
    public void onClick(View view) {
        String str = editText.getText().toString();
        switch (view.getId()) {
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
                    editText.setText("");
                }
                editText.setText(str + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.add:
            case R.id.subtract:
            case R.id.multi:
            case R.id.division:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str + "" + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.allclear:
                if (!clean) {
                    str = "";
                    editText.setText("");
                    clean = true;
                    break;
                }
                break;
            case R.id.backspace:
                if (!clean) {
                    str = str.substring(0, str.length() - 1);
                    editText.setText(str);
                    editText.setSelection(editText.getText().length());
                    if (str.equals("")) {
                        clean = true;
                        break;
                    }
                }
                break;

            case R.id.equal:
                if (!clean){
                    double res = calulate(str);
                    DecimalFormat decimalFormat = new DecimalFormat();
                    editText.setText(decimalFormat.format(res));
                    break;
                }
                break;
        }
    }


    private static Stack<String> postfixStack = new Stack<>(); //后缀表达式
    private static Stack<String> opStack = new Stack<>();  //操作符
    private static Stack<Double> result = new Stack<>();  //结果

//        计算
    public double calulate(String exp){
        potfix(exp);
        getResult();
        double number = result.peek();
        while (!result.empty()){
            result.pop();
        }

        return number;

    }
//        后缀表达式转换
        public void potfix(String exp){
            char[] arr = exp.toCharArray();
            for(int i =0; i<exp.length();i++){
                char c = arr[i];
                int count = (int) c;

//                数字部分
                if (count>=48&&count<=57){  //判断字符是否是数字与小数点
                    int j = i+1;
                    while (j<exp.length()&&(int) arr[j]>=48&&(int) arr[j]<=57){ //判断多位数压入栈中
                        j++;
                    }
                    postfixStack.push(exp.substring(i,j));
                    i=j-1;
                }
//                括号部分
                else if (c == '('){  //左括号直接压入操作符栈
                    opStack.push(String.valueOf(arr[i]));
                }
                else if(c == ')'){  //右括号
                    while (!opStack.peek().equals('(')){  //栈中无左括号，将操作符出栈压入后缀栈
                        postfixStack.push(opStack.pop());
                    }
                    opStack.pop();  //操作符出栈
                }
//                操作符部分
                else {
                    int n = 0;  //初始优先级为0
                    if(!opStack.empty()){  //操作栈不空
                            n = opPriority(opStack.lastElement());
                    }
                    int m = opPriority(String.valueOf(arr[i]));
                    if(m>=n){  //当前操作符优先级大于栈顶元素，直接入栈
                        opStack.push(String.valueOf(arr[i]));
                    }
                    else {
                        while (m < n) {
                            postfixStack.push(opStack.pop());
                            if(!opStack.empty()){
                                n = opPriority(opStack.peek());
                            }
                            else {
                                n = 0;
                            }
                        }
                        opStack.push(String.valueOf(c));
                    }
                }
            }
            while (!opStack.empty()){
                postfixStack.push(opStack.pop());
            }
        }

    //        运算符优先级
     private  int opPriority(String c){
        int n = 0;
        switch (c) {
            case "+":
            case "-":
                n = 1;
                break;
            case "×":
            case "÷":
                n = 2;
                break;
        }
        return  n;
    }


//    将后缀表达式反转遍历，遇到数字加入result，遇到符号从result中取出两数进行运算，结果加入result
    private void getResult(){
            Stack<String> t = new Stack<>();  //反转后缀表达式栈
            while (!postfixStack.empty()){
                t.push(postfixStack.pop());
            }
            String str = t.pop();
            while (str != null){
                if(str.equals("+")||str.equals("-")||str.equals("×")||str.equals("÷")){
                    double n = result.pop();
                    double m = result.pop();
                    double num = 0;
                    if(str.equals("+")) num = m+n;
                    if(str.equals("-")) num = m-n;
                    if(str.equals("×")) num = m*n;
                    if(str.equals("÷")) num = m/n;
                    result.push(num);
            }
                else {
                    result.push(Double.parseDouble(str));   //将数字放入结果栈
                }
                if(!t.empty()){
                    str = t.pop();
                }
                else {
                    str = null;
                }
            }
    }



}
