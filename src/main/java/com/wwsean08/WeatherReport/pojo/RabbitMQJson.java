package com.wwsean08.WeatherReport.pojo;

import com.google.gson.annotations.SerializedName;
import com.sun.glass.ui.SystemClipboard;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class RabbitMQJson
{
    @SerializedName("location")
    private String location;
    @SerializedName("temperature")
    private float temp;
    @SerializedName("icon")
    private String icon;
    @SerializedName("timestamp")
    private long timestamp = System.currentTimeMillis();

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public float getTemp()
    {
        return temp;
    }

    public void setTemp(float temp)
    {
        this.temp = temp;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }
}
