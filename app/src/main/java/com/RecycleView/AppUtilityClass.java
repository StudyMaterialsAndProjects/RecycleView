package com.RecycleView;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class AppUtilityClass {
    private String [] names;
    private String [] gender;
    private String [] lastnames;
    private String [] nationalities;

    private Context appUtilitycontext;
    private List<Person> people;
    private static AppUtilityClass stc_appUtilityClass;

    private AppUtilityClass(Context context){
       this.appUtilitycontext=context;
       names=context.getResources().getStringArray(R.array.names);
       gender=context.getResources().getStringArray(R.array.gender);
       lastnames=context.getResources().getStringArray(R.array.lastnames);
       nationalities=context.getResources().getStringArray(R.array.nationality);
       people=new ArrayList<Person>();
        for (int i = 0; i < names.length; i++) {
            Person person=new Person(names[i],lastnames[i],
                    gender[i].equalsIgnoreCase("male")? Person.GENDER.MALE: Person.GENDER.FEMALE,
                    nationalities[i]);
            people.add(person);
        }
    }

    public static AppUtilityClass getStc_appUtilityClass(Context context){
            if(stc_appUtilityClass==null){
                    stc_appUtilityClass=new AppUtilityClass(context);
            }
            return stc_appUtilityClass;
    }

    public List<Person> getPeople(){
        return  people;
    }

    public String [] getNames(){
        return names;
    }
    public String [] getLastnames(){
        return lastnames;
    }
    public String [] getGender(){
            return gender;
    }
    public  String [] getNationalities(){
        return  nationalities;
    }
}
