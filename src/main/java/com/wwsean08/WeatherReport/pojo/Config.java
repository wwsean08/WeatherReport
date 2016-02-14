package com.wwsean08.WeatherReport.pojo;

/**
 * Created by wwsea_000 on 1/1/2016.
 * POJO Containing all the config options
 */
public class Config
{
    /**
     * Location of the RabbitMQ server, defaults to localhost
     */
    private String rabbitmqServer = "localhost";

    /**
     * The username for rabbitMQ, defaults to guest
     */
    private String rabbitmqUser = "guest";

    /**
     * The password for rabbitMQ, defaults to guest
     */
    private String rabbitmqPassword = "guest";

    /**
     * Update interval in minutes, defaults to 15
     */
    private int updateInterval = 15;

    /**
     * The state to get a weather report for, defaults to WA
     */
    private String state = "WA";

    /**
     * The city to get a weather report for, defaults to Seattle
     */
    private String city = "Seattle";

    /**
     * The API key for accessing Weather Underground
     */
    private String key = null;

    public String getRabbitmqServer()
    {
        return rabbitmqServer;
    }

    public void setRabbitmqServer(String rabbitmqServer)
    {
        this.rabbitmqServer = rabbitmqServer;
    }

    public String getRabbitmqUser()
    {
        return rabbitmqUser;
    }

    public void setRabbitmqUser(String rabbitmqUser)
    {
        this.rabbitmqUser = rabbitmqUser;
    }

    public String getRabbitmqPassword()
    {
        return rabbitmqPassword;
    }

    public void setRabbitmqPassword(String rabbitmqPassword)
    {
        this.rabbitmqPassword = rabbitmqPassword;
    }

    public int getUpdateInterval()
    {
        return updateInterval;
    }

    public void setUpdateInterval(int updateInterval)
    {
        this.updateInterval = updateInterval;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
