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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scientific extends AppCompatActivity implements  View.OnClickListener{

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

    //sin、cos、tan
    private Button sin;
    private Button cos;
    private Button tan;

    private Button l_kuohao;
    private Button r_kuohao;

    private Button log;
    private Button ln;
    private Button xpingfang;
    private Button xlifang;


    private Button genhao;
    private Button xncifang;
    private Button tennicifang;

    private Button EE;
    private Button Pi;
    private Button e;


    boolean clean;  //文本框空标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.science);
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

//        science
        l_kuohao = findViewById(R.id.lbracket);
        r_kuohao = findViewById(R.id.rbracket);

        xpingfang = findViewById(R.id.square);
        xlifang = findViewById(R.id.cube);

        log = findViewById(R.id.log);
        ln = findViewById(R.id.ln);

        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);

        genhao = findViewById(R.id.squareroot);
        xncifang = findViewById(R.id.xncifang);
        tennicifang = findViewById(R.id.tenncifang);

        e = findViewById(R.id.e);
        Pi = findViewById(R.id.PI);
        EE = findViewById(R.id.EE);



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

        //        science
        l_kuohao.setOnClickListener(this);
        r_kuohao.setOnClickListener(this);

        xpingfang.setOnClickListener(this);
        xlifang.setOnClickListener(this);

        log.setOnClickListener(this);
        ln.setOnClickListener(this);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);

        genhao.setOnClickListener(this);
        xncifang.setOnClickListener(this);
        tennicifang.setOnClickListener(this);

        e.setOnClickListener(this);
        Pi.setOnClickListener(this);
        EE.setOnClickListener(this);


        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_list.clear();
                Intent intent = new Intent(Scientific.this,HistoryList.class);
                startActivity(intent);


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Scientific.this,MainActivity.class);
                startActivity(intent);
            }
        });


//        光标显示但不召出软键盘
        editText.setShowSoftInputOnFocus(false);





    }


    @Override
    public void onClick(View view) {
//        因数字长度变化而改变文字大小
//        if(editText.length()>=10)
//        {
//            editText.setTextSize(35);
//        }
//        else
//        {
//            editText.setTextSize(60);
//        }

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
            case R.id.log:
            case R.id.ln:
            case R.id.sin:
            case R.id.cos:
            case R.id.tan:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;

            case R.id.lbracket:
            case R.id.rbracket:
            case R.id.e:
            case R.id.PI:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str + ((Button) view).getText().toString() + "");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;

            case R.id.EE:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "E");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.square:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "^2");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.cube:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "^3");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.xncifang:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "^");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.tenncifang:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "10^");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
                break;
            case R.id.squareroot:
                if (clean) {
                    clean = false;
                    editText.setText("");
                }
                editText.setText(str  + "√");
                editText.setSelection(editText.getText().length());
                editText.getSelectionEnd();
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
                editText.setText(decimalFormat.format(number));
                history_p2= editText.getText().toString();
            }
            else{
                editText.setText(decimalFormat.format(number));
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

//        匹配数字与运算符连接情况
        Pattern p1 = Pattern.compile("[0-9]π");
        Pattern p2 = Pattern.compile("[0-9]e");
        Pattern p3 = Pattern.compile("[0-9]√");
        Pattern p4 = Pattern.compile("[0-9]l");
        Pattern p5 = Pattern.compile("[0-9]s");
        Pattern p6 = Pattern.compile("[0-9]c");
        Pattern p7 = Pattern.compile("[0-9]t");
        Matcher matcher1 = p1.matcher(exp);
        Matcher matcher2 = p2.matcher(exp);
        Matcher matcher3 = p3.matcher(exp);
        Matcher matcher4 = p4.matcher(exp);
        Matcher matcher5 = p5.matcher(exp);
        Matcher matcher6 = p6.matcher(exp);
        Matcher matcher7 = p7.matcher(exp);
        if(matcher1.find()){
            int index = exp.indexOf("π");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher2.find()){
            int index = exp.indexOf("e");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher3.find()){
            int index = exp.indexOf("√");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher4.find()){
            int index = exp.indexOf("l");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher5.find()){
            int index = exp.indexOf("s");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher6.find()){
            int index = exp.indexOf("c");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }
        if(matcher7.find()){
            int index = exp.indexOf("t");
            int end = exp.length();
            exp = exp.substring(0,index)+"×"+exp.substring(index,end);
        }


        exp = exp.replaceAll(",","");
        char[] arr = exp.toCharArray();
        for(int i =0; i<exp.length();i++){
            char c = arr[i];
            int count = (int) c;
            if(i==0&&count==45){
                postfixStack.push("0");
            }

//                数字部分
            if (count>=48&&count<=57||count == 46||c=='e'||c=='E'||c=='π'){  //判断字符是否是数字与小数点
                int j = i+1;
                while (j<exp.length()&& ((int) arr[j]>=48&&(int)arr[j]<=57 ||arr[j] == '.'||(int)arr[j]==69||arr[j] == 'E')){ //判断多位数压入栈中
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
                int m=0;
                String opstr=null;
                if(!opStack.empty()){  //操作栈不空
                    n = opPriority(opStack.lastElement());
                }
                if((c == 's'&&arr[i+1]=='i'&&arr[i+2]=='n')||(c == 'c'&&arr[i+1]=='o'&&arr[i+2]=='s')
                        ||(c == 't'&&arr[i+1]=='a'&&arr[i+2]=='n')||(c == 'l'&&arr[i+1]=='o'&&arr[i+2]=='g')){
                    opstr=arr[i]+""+arr[i+1]+""+arr[i+2];
                    m = opPriority(opstr);
                    i=i+2;
                }
                else if(c == 'l'&&arr[i+1]=='n'){
                    opstr=arr[i]+""+arr[i+1]+"";
                    m = opPriority(opstr);
                    i=i+1;
                }
                else {
                    opstr=arr[i]+"";
                    m = opPriority(String.valueOf(arr[i]));
                }
                if(m>n){  //当前操作符优先级大于栈顶元素，直接入栈
                    opStack.push(opstr);
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
            case "%":
                n = 2;
                break;
            case "^":
            case "√":
            case "sin":
            case "cos":
            case "tan":
            case "log":
            case "ln":
                n = 3;
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
            if(str.equals("+")||str.equals("-")||str.equals("×")||str.equals("÷")||str.equals("^")){
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
                if(str.equals("^")) num = Math.pow(m,n);

                result.push(num);
            }
            else if(str.equals("√")){
                double n = result.pop();
                result.push(Math.sqrt(n));
            }
            else if(str.equals("sin")){
                double n = result.pop();
                result.push(Math.sin(n));
            }
            else if(str.equals("cos")){
                double n = result.pop();
                result.push(Math.cos(n));
            }
            else if(str.equals("tan")){
                double n = result.pop();
                result.push(Math.tan(n));
            }
            else if(str.equals("log")){
                double n = result.pop();
                result.push(Math.log10(n));
            }
            else if(str.equals("ln")){
                double n = result.pop();
                result.push(Math.log(n));
            }
            else if (str.equals(".")){
                result.push(0.0);
            }
            else if(str.equals("%")){
                double n = result.pop();
                result.push(n*0.01);
            }
            else{
                if(str.equals("e"))
                    result.push(Math.E);
                else if (str.equals("π"))
                    result.push(Math.PI);
                else
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
