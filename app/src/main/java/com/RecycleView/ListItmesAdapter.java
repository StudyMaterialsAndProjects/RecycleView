package com.RecycleView;

import android.content.Context;
import android.util.ArraySet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Set;

public class ListItmesAdapter extends BaseAdapter {

    private static final String TAG = ListItmesAdapter.class.getSimpleName();

    List<Person> personList;
    Context context;
    LayoutInflater layoutInflater;
    Set<View> viewSet;

    ListItmesAdapter(Context cons_context,List<Person> cons_personList){
                this.context=cons_context;
                this.personList=cons_personList;
                this.viewSet=new ArraySet<>();
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonViewHolder personViewHolder; // Here i am not intializing the PersonViewHolder.
            if(convertView==null){
                layoutInflater=LayoutInflater.from(this.context);
                convertView=layoutInflater.inflate(R.layout.layout_person_row_item,null);
                /**
                 * if the View==null then only i am intalizing the Views.
                 */
                personViewHolder=new PersonViewHolder();
                personViewHolder.mtextViewName=((TextView)convertView.findViewById(R.id.textViewName));
                personViewHolder.mtextViewLastName=((TextView)convertView.findViewById(R.id.textViewName));
                personViewHolder.mtextViewGender=((TextView)convertView.findViewById(R.id.textViewName));
                personViewHolder.mtextViewNationality=((TextView)convertView.findViewById(R.id.textViewName));
                convertView.setTag(personViewHolder); // Do some R and D on setTag.
            }else{
                personViewHolder=(PersonViewHolder)convertView.getTag();
            }
            final  Person person=personList.get(position);
                personViewHolder.mtextViewName.setText(person.getName());
                personViewHolder.mtextViewLastName.setText(person.getName());
                personViewHolder.mtextViewGender.setText(person.getName());
                personViewHolder.mtextViewNationality.setText((person.getGender()==Person.GENDER.MALE? "Male":"Female"));
                viewSet.add(convertView);
           Log.i(TAG,"Index = "+position+" : "+convertView+"Size of the Set = "+viewSet.size());
        return convertView;
    }

    private static class PersonViewHolder{
        /**
         * This class will hold all the individual views required for the layout.
         */
        public TextView mtextViewName;
        public TextView mtextViewLastName;
        public TextView mtextViewGender;
        public TextView mtextViewNationality;
    }
}
