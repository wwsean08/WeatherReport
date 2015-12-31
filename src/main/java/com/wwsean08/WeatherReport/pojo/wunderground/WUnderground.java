package com.wwsean08.WeatherReport.pojo.wunderground;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class WUnderground
{
    @SerializedName("current_observation")
    private CurrentObservation current;

    public String getLocation()
    {
        return current.getLocation().getLocation();
    }

    public String getIconURL()
    {
        return current.getIconURL();
    }

    public float getTemp()
    {
        return current.getTemp();
    }
}
