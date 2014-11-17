package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by Kongoji on 14.11.14.
 */
public class ReanimationStorageManager {

    private static ReanimationStorageManager instance;
    private Activity activity;
    private String data;

    private Stack<String> input;

    private FileOutputStream stream;
    private StringBuilder builder;

    private SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "Reanimationen" ;
    private String prefName = "reanimation";




    private ReanimationStorageManager(Activity activity) {
        this.builder = new StringBuilder();
        this.activity = activity;
        input = new Stack<String>();
    }

    public static ReanimationStorageManager getInstance(Activity activity) {
        instance = new ReanimationStorageManager(activity);
        return instance;
    }

    public void delete(){
        sharedPreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }



    public void cache(String info) {
       input.push(info);
    }

    public void undoCache(){
        input.pop();
    }


    public void save(){

        sharedPreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (String temp : input){
            builder.append(temp);
        }

        editor.putString(prefName,builder.toString());
       // editor.putString(prefName, builder.toString());
        editor.commit();

    }





}
