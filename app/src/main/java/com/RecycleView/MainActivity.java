package com.RecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    AppUtilityClass appUtilityClass;
    ListItmesAdapter listItmesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeView();
        getAppUtilityClass_Context();
        intializeAdapter();
        setListViewAdapter();

    }

    private void intializeView(){
        listView=(ListView)findViewById(R.id.mainActivity_listView);
    }
    private void getAppUtilityClass_Context(){
            appUtilityClass=AppUtilityClass.getStc_appUtilityClass(this);
    }
    private void intializeAdapter(){
    listItmesAdapter=new ListItmesAdapter(this,appUtilityClass.getPeople());
    }
    private void setListViewAdapter(){
        listView.setAdapter(listItmesAdapter);
    }
}
