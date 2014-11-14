package com.example.kongoji.reanimationtest;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Kongoji on 14.11.14.
 */
public class ReanimationStorageManager {

    private static ReanimationStorageManager instance;
    private Activity activity;
    private String data;
    private String fileName = "reanimation";
    private FileOutputStream stream;
    private StringBuilder builder;

    private ReanimationStorageManager(Activity activity) {
        this.builder = new StringBuilder();
        this.activity = activity;
    }

    public static ReanimationStorageManager getInstance(Activity activity) {
        instance = new ReanimationStorageManager(activity);
        return instance;
    }

    private boolean fileExistance(String fname) {
        File file = activity.getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }

    public void cache(String info) {
        builder.append(info);
        builder.append("\n");
    }


    public void save(View view) {
        if (!fileExistance(fileName)) {
            fileName = fileName + "1";
            File file = new File(activity.getBaseContext().getFilesDir(), String.valueOf(fileName));
        }

        try {
            stream = activity.openFileOutput(fileName, Context.MODE_PRIVATE);
            stream.write(builder.toString().getBytes());
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
