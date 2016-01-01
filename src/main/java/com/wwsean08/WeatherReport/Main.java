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
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
        // Run an update every 15 minutes starting now, and watch for update
        // requests
        try
        {
            threadPool.scheduleAtFixedRate(new ScheduledRunner(), 0, 15, TimeUnit.MINUTES);
            threadPool.schedule(new OnDemandRunner(), 0, TimeUnit.MINUTES);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
