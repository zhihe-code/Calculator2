package com.example.calculator2;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Normal extends AppCompatActivity implements  View.OnClickListener{

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


    //文本框空标记
    boolean clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
//        全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        实例化
//        数字
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

//        加减乘除、百分号、小数点、等号、取负
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multi = findViewById(R.id.multi);
        division = findViewById(R.id.division);
        precent = findViewById(R.id.precent);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        plusorminus = findViewById(R.id.plusorminus);


//        全清、退格
        allclear = findViewById(R.id.allclear);
        backspace = findViewById(R.id.backspace);
//        历史记录、页面回退
        history = findViewById(R.id.history);
        back = findViewById(R.id.back);
//        结果显示文本框
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
        precent.setOnClickListener(this);

        equal.setOnClickListener(this);
        plusorminus.setOnClickListener(this);


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_list.clear();
                Intent intent = new Intent(Normal.this,HistoryList.class);
                startActivity(intent);


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Normal.this,MainActivity.class);
                startActivity(intent);
            }
        });


//        光标显示但不召出软键盘
        editText.setShowSoftInputOnFocus(false);





    }


    @Override
    public void onClick(View view) {
//        因数字长度变化而改变文字大小
        if(editText.length()>=10)
        {
            editText.setTextSize(35);
        }
        else
        {
            editText.setTextSize(60);
        }

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
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                if(!str.endsWith("+"))
                    editText.setText(str + "" + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.subtract:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                if(!str.endsWith("-"))
                    editText.setText(str + "" + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.multi:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                if(!str.endsWith("×"))
                    editText.setText(str + "" + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.division:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                if(!str.endsWith("÷"))
                    editText.setText(str + "" + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.precent:
                if (clean) {
                    clean = false;
                    editText.setText("");

                }
                if(!str.endsWith("%")){
                    editText.setText(str + "" + ((Button) view).getText().toString() + "");
                }
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.allclear:
                if (!clean) {
                    editText.setText("");
                    clean = true;
                    break;
                }
                break;
            case R.id.backspace:
                if (!clean) {
                    int index = editText.getSelectionStart();
                    try{
                        str = str.substring(0,index-1)+str.substring(index,editText.getText().length());
                        editText.setText(str + "" );
                        editText.setSelection(index-1);
                    }catch (Exception e){
                        
                    }
                    if (str.equals("")) {
                        clean = true;
                        break;
                    }

                }
            break;

            case R.id.equal:
                if (!clean){
                    calulate(str);
                    editText.setSelection(editText.getText().length());
                    editText.getSelectionEnd();
                    break;
                }

                break;
            case R.id.plusorminus:
                if (!clean){
                    calulate("("+str+")×(0-1)");
                    editText.setSelection(editText.getText().length());
                    editText.getSelectionEnd();
                    break;
                }
                break;

        }
    }


    private static Stack<String> postfixStack = new Stack<>(); //后缀表达式
    private static Stack<String> opStack = new Stack<>();  //操作符
    private static Stack<Double> result = new Stack<>();  //结果
    private static List<String> history_list = new ArrayList<>();

//        计算
    public void calulate(String exp){
        potfix(exp);
        try{
            getResult();
            double number = result.peek();
            String num = Double.toString(number);
            DecimalFormat decimalFormat = new DecimalFormat();
            String history;
            String history_p1= editText.getText().toString();
            String history_p2 = "";
            if(num.indexOf("E")>10){
                decimalFormat.applyPattern("#.########E0");
                editText.setText(Double.toString(number));
                history_p2= editText.getText().toString();
            }
            else{
                editText.setText(Double.toString(number));
                history_p2= editText.getText().toString();

            }
            if(history_p2.endsWith(history_p1)) {
                history = history_p2;
            }
            else
                history = history_p1 + "="+history_p2;
            history_list.add(history);
            saveArray();
            while (!result.empty()){  //清空结果栈
                result.pop();
            }

        }
        catch(Exception e) {
            editText.setText("错误");
        }

    }
//        后缀表达式转换
        public void potfix(String exp){
            exp=exp.replaceAll(",","");
            char[] arr = exp.toCharArray();
            for(int i =0; i<exp.length();i++){
                char c = arr[i];
                int count = (int) c;
                if(i==0&&count==45){
                    postfixStack.push("0");
                }

//                数字部分
                if (count>=48&&count<=57||count == 46){  //判断字符是否是数字与小数点
                    int j = i+1;
                    while (j<exp.length()&& ((int) arr[j]>=48&&(int)arr[j]<=57 ||arr[j] == '.'||(int)arr[j]==69)){ //判断多位数压入栈中
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
                    while (!opStack.lastElement().equals("(")){  //栈顶未匹配左括号，将操作符出栈压入后缀栈
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
                    if(m>n){  //当前操作符优先级大于栈顶元素，直接入栈
                        opStack.push(String.valueOf(arr[i]));
                    }
                    else {
                        while (m <= n) {
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
            case "%":
                n = 3;
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
                    double m = 0.0;
                    double num = 0;

                    if(!result.empty()){
                        m = result.pop();
                    }
                    if(str.equals("+")) num = m+n;
                    if(str.equals("-")) num = m-n;
                    if(str.equals("×")) num = m*n;
                    if(str.equals("÷")) num = m/n;

                    result.push(num);
            }
                else if (str.equals(".")){
                    result.push(0.0);
                }
                else if(str.equals("%")){
                    double n = result.pop();
                    result.push(n*0.01);
                }
                else{
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

public  boolean saveArray() {
    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
    editor.putInt("list_size",history_list.size());
    for (int i = 0; i<history_list.size();i++)
        editor.putString("history"+i,history_list.get(i));

    return editor.commit();
}



}
