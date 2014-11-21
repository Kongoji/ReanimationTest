package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by danielreinhardt on 21.11.14.
 */
public class LoadSpinners extends AsyncTask<String,String,String> {



    Activity activity;
    Context context;

    public LoadSpinners(Activity activity, Context context) {
        this.activity = activity;
        this.context = context;
    }


    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
