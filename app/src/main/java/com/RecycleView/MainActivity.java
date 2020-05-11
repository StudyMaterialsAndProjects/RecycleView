package com.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    AppUtilityClass appUtilityClass;
    ListAdapterWithRecycleView listAdapterWithRecycleView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeView();
        getAppUtilityClass_Context();
    /**
 * RecycleView Steps.
 *  1)intializeAdapter();
 *  2)intializeLayoutManager();
 *  3)setListViewAdapter();
 *
 */
        intializeListAdapterWithRecycleView();
        intializeLayoutManagertoRecycleView();
        setlistAdapterWithRecycleViewr();

    }

    private void intializeView() {
        recyclerView = (RecyclerView) findViewById(R.id.mainActivity_recycleView);
    }

    private void getAppUtilityClass_Context() {
        appUtilityClass = AppUtilityClass.getStc_appUtilityClass(this);
    }

    /**
     * RecycleView Creation Steps.
     */

    private void intializeListAdapterWithRecycleView() {
        listAdapterWithRecycleView = new ListAdapterWithRecycleView(this, appUtilityClass.getPeople());
    }
    private void intializeLayoutManagertoRecycleView(){
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (position%3==0?2:1);  // Taking the postion and dividing it by 3.If the Remainder is 0 then span size = 2 else span size =1.
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setlistAdapterWithRecycleViewr() {
        recyclerView.setAdapter(listAdapterWithRecycleView);
    }
}
