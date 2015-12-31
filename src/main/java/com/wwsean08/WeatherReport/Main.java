package com.wwsean08.WeatherReport;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class Main
{
    public static void main(String[] args)
    {
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        //Run an update every 15 minutes starting now
        try
        {
            threadPool.scheduleAtFixedRate(new Runner(), 0, 15, TimeUnit.MINUTES);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
