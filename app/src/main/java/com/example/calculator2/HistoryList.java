package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryList extends AppCompatActivity {
    private String history;
    private List<String> list = new ArrayList<>();
    private Button clean_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);
        //        使用ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        clean_all = findViewById(R.id.clean_all);
        final SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        int size = pref.getInt("list_size",0);
        for(int i=0;i<size;i++) {
            history=pref.getString("history"+i,null);
            list.add(history);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(HistoryList.this,android.R.layout.simple_list_item_1,list);
        final ListView listView = (ListView) findViewById(R.id.historylist);
        listView.setAdapter(adapter);
        clean_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanSharedPreference(view.getContext());
                list.clear();
                adapter.notifyDataSetChanged();
                Toast.makeText(HistoryList.this,"清空成功！",Toast.LENGTH_SHORT).show();
            }
        });

    }
    //删除内置数据库
    public static void cleanSharedPreference(Context context) {
        context.deleteSharedPreferences("data");
    }


}
