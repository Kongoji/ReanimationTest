package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.io.FileOutputStream;
import java.util.Stack;

/**
 * Created by Kongoji on 14.11.14.
 */
public class ReanimationStorageManager{

    private static ReanimationStorageManager instance;
    private Activity activity;
    private String data;

    private Stack<String> input;

    private FileOutputStream stream;
    private StringBuilder builder;

    private SharedPreferences sharedPreferences;

    public static final String MyPREFERENCES = "Reanimationen";
            //"Einsatzprotokoll_" + TimeStampGenerator.getDate();
    private String prefName = "reanimation";


    private ReanimationStorageManager(Activity activity) {
        this.builder = new StringBuilder();
        this.activity = activity;
        input = new Stack<String>();
    }

    public static ReanimationStorageManager getInstance(Activity activity) {
        if (instance == null) {
            instance = new ReanimationStorageManager(activity);
        }
        return instance;
    }

    public void delete() {
        sharedPreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


    public void cache(String info) {
        input.push(info);
    }

    public void undoCache() {
        input.pop();
    }


    public void save() {

        sharedPreferences = activity.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (String temp : input) {
            builder.append(temp);
        }

        editor.putString(prefName, builder.toString());
        // editor.putString(prefName, builder.toString());
        editor.commit();

    }


}
