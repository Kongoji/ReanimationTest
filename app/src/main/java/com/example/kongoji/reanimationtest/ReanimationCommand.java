package com.example.kongoji.reanimationtest;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public abstract class ReanimationCommand {

    public void notifyUser(Context context, String text) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

    public abstract void execute();

    public abstract void undo();

    public abstract String getLogInfo();


}
