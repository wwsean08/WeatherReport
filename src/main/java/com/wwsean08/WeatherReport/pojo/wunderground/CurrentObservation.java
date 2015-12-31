package com.wwsean08.WeatherReport.pojo.wunderground;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class CurrentObservation
{
    @SerializedName("display_location")
    private DisplayLocation location;
    @SerializedName("icon_url")
    private String iconURL;
    @SerializedName("temp_f")
    private float temp;

    public DisplayLocation getLocation()
    {
        return location;
    }

    public String getIconURL()
    {
        return iconURL;
    }

    public float getTemp()
    {
        return temp;
    }
}
