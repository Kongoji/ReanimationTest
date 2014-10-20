package com.example.kongoji.reanimationtest;

import java.util.Calendar;

/**
 * Created by danielreinhardt on 20.10.14.
 */
public abstract class ReanimationCommand {


    public String getTimeStamp() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);
    }


    public abstract void execute();

    public abstract void undo();

}
