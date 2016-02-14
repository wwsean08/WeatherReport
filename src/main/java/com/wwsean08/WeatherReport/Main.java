package com.wwsean08.WeatherReport;

import com.wwsean08.WeatherReport.pojo.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
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
        Main main = new Main();
        String configFileLocation = null;
        if (args.length == 1)
        {
            configFileLocation = args[0];
        }
        Config config = main.parseConfig(configFileLocation);

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
        // Run an update every 15 minutes starting now, and watch for update
        // requests
        try
        {
            threadPool.scheduleAtFixedRate(new WeatherRunner(config), 0,
                    config.getUpdateInterval(), TimeUnit.MINUTES);
            threadPool.schedule(new OnDemandRunner(config), 0, TimeUnit.MINUTES);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private Config parseConfig(String configFile)
    {
        Config config = new Config();
        //Parse it and populate the config, otherwise defaults will be used
        if (configFile != null)
        {
            File file = new File(configFile);
            if (file.exists())
            {
                try
                {
                    InputStream FIS = new FileInputStream(file);
                    Properties prop = new Properties();
                    prop.load(FIS);
                    config.setRabbitmqPassword(prop.getProperty(Constants.RMQ_PASS_KEY, config.getRabbitmqPassword()));
                    config.setRabbitmqUser(prop.getProperty(Constants.RMQ_USER_KEY, config.getRabbitmqUser()));
                    config.setRabbitmqServer(prop.getProperty(Constants.RMQ_SERVER_KEY, config.getRabbitmqServer()));
                    config.setUpdateInterval(Integer.parseInt(
                            prop.getProperty(Constants.REFRESH_KEY, String.valueOf(config.getUpdateInterval()))));
                    config.setState(prop.getProperty(Constants.STATE_KEY, config.getState()));
                    config.setCity(prop.getProperty(Constants.CITY_KEY, config.getCity()));
                    config.setKey(prop.getProperty(Constants.APIKEY_KEY, config.getKey()));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return config;
    }
}
