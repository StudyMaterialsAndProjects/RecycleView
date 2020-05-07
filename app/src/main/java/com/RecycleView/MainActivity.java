package com.RecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    AppUtilityClass appUtilityClass;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeView();
        getAppUtilityClass_Context();
        intializeAdpaterData();
        setListViewAdapter();

    }

    private void intializeView(){
        listView=(ListView)findViewById(R.id.mainActivity_listView);
    }
    private void getAppUtilityClass_Context(){
            appUtilityClass=AppUtilityClass.getStc_appUtilityClass(this);
    }
    private void intializeAdpaterData(){
        adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,appUtilityClass.getNames());
    }
    private void setListViewAdapter(){
        listView.setAdapter(adapter);
    }

}
