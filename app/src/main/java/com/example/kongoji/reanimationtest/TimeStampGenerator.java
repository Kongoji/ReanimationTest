package com.example.kongoji.reanimationtest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Kongoji on 18.11.14.
 */
public class TimeStampGenerator {

    public static String getTimeStamp() {

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String getDate() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());

    }
}
