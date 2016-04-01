package com.wwsean08.WeatherReport.pojo.wunderground;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class CurrentObservation
{
    @SerializedName("display_location")
    private DisplayLocation location;
    @SerializedName("weather")
    private String weatherCondition;
    @SerializedName("icon_url")
    private String iconURL;
    @SerializedName("temp_f")
    private float temp;
    @SerializedName("local_epoch")
    private long localEpochTime;


    public DisplayLocation getLocation()
    {
        return location;
    }

    public String getWeatherCondition()
    {
        return weatherCondition;
    }

    public float getTemp()
    {
        return temp;
    }

    public long getLocalEpochTime() { return localEpochTime;}

    public String getIconURL() { return iconURL; }
}
