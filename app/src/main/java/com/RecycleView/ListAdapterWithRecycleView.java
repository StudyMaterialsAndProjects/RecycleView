package com.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListAdapterWithRecycleView extends RecyclerView.Adapter<ListAdapterWithRecycleView.PersonViewHolder> {

    public static final String TAG=ListAdapterWithRecycleView.class.getSimpleName();

    private List<Person> personList;
    private Context context;

    ListAdapterWithRecycleView(Context cons_context,List<Person> cons_personList){
        this.context=cons_context;
        this.personList=cons_personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_person_row_item,parent,false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        final  Person person=personList.get(position);
        holder.textViewName.setText(person.getName());
        holder.textViewGender.setText((person.getGender()==Person.GENDER.MALE? "Male":"Female"));
        holder.textViewNationality.setText(person.getNationality());
        holder.textViewLastName.setText(person.getLastname());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewGender;
        public TextView textViewNationality;
        public TextView textViewLastName;

        PersonViewHolder(View view) {
            super(view);
            textViewName=  (TextView)view.findViewById(R.id.textViewName);
            textViewGender=  (TextView)view.findViewById(R.id.textViewGender);
            textViewNationality=  (TextView)view.findViewById(R.id.textViewNationality);
            textViewLastName=  (TextView)view.findViewById(R.id.textViewLastName);
        }
    }
}