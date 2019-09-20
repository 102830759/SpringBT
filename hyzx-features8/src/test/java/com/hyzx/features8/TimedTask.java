package com.hyzx.features8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author huyue
 * @date 2019/9/9 10:30
 */
public class TimedTask {

    @Test
    public void sss(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            Date date = dateFormat.parse("2019-09-09 10:40:00.000");
            new Timer("testTimer1").scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("TimerTask");
                }
            }, date,2000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ssss(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse("2019-09-09 10:53:00");
            new Timer(true).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("TimerTask");
                }
            }, date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
