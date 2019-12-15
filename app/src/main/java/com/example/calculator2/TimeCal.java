package com.example.calculator2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;



public class TimeCal extends AppCompatActivity implements  View.OnTouchListener{



    private EditText etStartTime;
    private EditText etEndTime;
    private TextView day_show;
    private TextView year_show;
    private TextView month_show;
    private TextView hour_show;
    private TextView minute_show;
    private String start;
    private String end;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        etStartTime = (EditText) this.findViewById(R.id.editText1);
        etEndTime = (EditText) this.findViewById(R.id.editText2);

        day_show = (TextView) findViewById(R.id.day_show);
        year_show = (TextView) findViewById(R.id.year_show);
        month_show = (TextView) findViewById(R.id.month_show);
        hour_show = (TextView) findViewById(R.id.hour_show);
        minute_show = (TextView) findViewById(R.id.minute_show);

        etStartTime.setOnTouchListener(this);
        etEndTime.setOnTouchListener(this);



    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = View.inflate(this, R.layout.time_choose, null);
            final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
            final TimePicker timePicker = (TimePicker) view.findViewById(R.id.time_picker);
            builder.setView(view);

            //设置为当前日期
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

            //设置为当前时间
            timePicker.setIs24HourView(true);
            timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
            timePicker.setCurrentMinute(Calendar.MINUTE);
            if (v.getId() == R.id.editText1) {
                final int inType = etStartTime.getInputType();
                etStartTime.setInputType(InputType.TYPE_NULL);
                etStartTime.onTouchEvent(event);
                etStartTime.setInputType(inType);
                etStartTime.setSelection(etStartTime.getText().length());
                builder.setTitle("选取起始时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(timePicker.getCurrentHour())
                                .append(":").append(timePicker.getCurrentMinute());

                        etStartTime.setText(sb);
                        start=sb.toString();
                        etEndTime.requestFocus();

                        dialog.cancel();
                    }
                });

            } else if (v.getId() == R.id.editText2) {
                int inType = etEndTime.getInputType();
                etEndTime.setInputType(InputType.TYPE_NULL);
                etEndTime.onTouchEvent(event);
                etEndTime.setInputType(inType);
                etEndTime.setSelection(etEndTime.getText().length());
                builder.setTitle("选取结束时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(timePicker.getCurrentHour())
                                .append(":").append(timePicker.getCurrentMinute());
                        etEndTime.setText(sb);
                        end=sb.toString();

                        dialog.cancel();
                        CalculateTime();
                    }
                });
            }

            Dialog dialog = builder.create();
            dialog.show();
        }

        return true;
    }

    public void CalculateTime(){
         try{
             DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
             Date startTime = df.parse(start);
             Date endTime = df.parse(end);
             long diff = endTime.getTime()-startTime.getTime();
             long days = diff / (60*1000*60*24);

             long year = days/365;
             long month2 = (diff-year*60*1000*60*24*365)/ (60*1000*60*24)/30;
             long day2= (diff-year*60*1000*60*24*365-month2*60*1000*60*24*30)/(60*1000*60*24);

             long months = days/30;
             long day3 = (diff-months*60*1000*60*24*30)/ (60*1000*60*24);

             long hours = diff / (60*1000*60);
             long minute2 = (diff-hours*(1000* 60 * 60))/(1000* 60);

             long minutes = diff/(60*1000);
             day_show.setText(Long.toString(days)+"天");
             month_show.setText(Long.toString(months)+"月"+Long.toString(day3)+"天");
             year_show.setText(Long.toString(year)+"年"+Long.toString(month2)+"月"+Long.toString(day2)+"天");
             hour_show.setText(Long.toString(hours)+"小时"+Long.toString(minute2)+"分钟");
             minute_show.setText(Long.toString(minutes)+"分钟");
         }catch (Exception e){

         }
    }

}






