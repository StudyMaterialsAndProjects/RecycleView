package com.RecycleView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListItmesAdapter extends BaseAdapter {

    private static final String TAG = ListItmesAdapter.class.getSimpleName();

    List<Person> personList;
    Context context;
    LayoutInflater layoutInflater;


    ListItmesAdapter(Context cons_context,List<Person> cons_personList){
                this.context=cons_context;
                this.personList=cons_personList;

    }


    @Override
    public int getCount() {
        System.out.println("FC getCount()");
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        System.out.println("FC getItem()");
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        System.out.println("FC getItemId()");
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("FC getView()");
            layoutInflater=LayoutInflater.from(this.context);
            final  Person person=personList.get(position);
            convertView=layoutInflater.inflate(R.layout.layout_person_row_item,null);
            ((TextView)convertView.findViewById(R.id.textViewName)).setText(person.getName());
            ((TextView)convertView.findViewById(R.id.textViewLastName)).setText(person.getLastname());
            ((TextView)convertView.findViewById(R.id.textViewGender)).setText(person.getNationality());
            ((TextView)convertView.findViewById(R.id.textViewNationality)).setText((person.getGender()==Person.GENDER.MALE? "Male":"Female"));
                Log.i(TAG,"Index = "+position+" : "+convertView);
        return convertView;
    }
}
