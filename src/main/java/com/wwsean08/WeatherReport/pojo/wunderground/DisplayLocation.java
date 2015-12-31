package com.wwsean08.WeatherReport.pojo.wunderground;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class DisplayLocation
{
    @SerializedName("full")
    private String location;

    public String getLocation()
    {
        return location;
    }
}
