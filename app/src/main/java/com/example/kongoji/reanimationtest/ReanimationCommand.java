package com.example.kongoji.reanimationtest;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public abstract class ReanimationCommand {


    public String getTimeStamp() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
    }

    public void notifyUser(Context context, String text){
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public abstract void execute();

    public abstract void undo();

    public abstract String getLogInfo();


}
