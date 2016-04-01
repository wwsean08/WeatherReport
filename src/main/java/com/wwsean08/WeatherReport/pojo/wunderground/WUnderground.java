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

    public String getWeatherCondition()
    {
        return current.getWeatherCondition();
    }

    public float getTemp()
    {
        return current.getTemp();
    }

    public long getLocalEpoch() { return current.getLocalEpochTime(); }

    public String getIconURL() {
        String iconURL = current.getIconURL();
        String result = "";
        //Parse out icon file name and determine appropriate class
        int index = iconURL.lastIndexOf("/");
        String wundergroundIcon = iconURL.substring(index);
        wundergroundIcon = wundergroundIcon.replace("/", "");
        switch (wundergroundIcon)
        {
            // DAY TIME IMAGES
            case "chancerain.gif":
            case "rain.gif":
                result = "wi-day-rain";
                break;
            case "chancetstorms.gif":
            case "tstorms.gif":
                result = "wi-day-lightning";
                break;
            case "clear.gif":
            case "sunny.gif":
                result = "wi-day-sunny";
                break;
            case "flurries.gif":
            case "snow.gif":
            case "chancesnow.gif":
            case "chanceflurries.gif":
                result = "wi-day-snow";
                break;
            case "fog.gif":
                result = "wi-day-fog";
                break;
            case "hazy.gif":
                result = "wi-day-haze";
                break;
            case "mostlycloudy.gif":
                result = "wi-cloudy";
                break;
            case "mostlysunny.gif":
            case "partlysunny.gif":
            case "partlycloudy.gif":
            case "cloudy.gif":
                result = "wi-day-cloudy";
                break;
            case "sleet.gif":
            case "chancesleet.gif":
                result = "wi-day-sleet";
                break;
            // END DAY TIME IMAGES
            // NIGHT TIME IMGAES
            case "nt_chancerain.gif":
            case "nt_rain.gif":
                result = "wi-night-alt-rain";
                break;
            case "nt_chancetstorms.gif":
            case "nt_tstorms.gif":
                result = "wi-night-alt-lightning";
                break;
            case "nt_clear.gif":
            case "nt_sunny.gif":
                result = "wi-night-clear";
                break;
            case "nt_flurries.gif":
            case "nt_snow.gif":
            case "nt_chancesnow.gif":
            case "nt_chanceflurries.gif":
                result = "wi-night-alt-snow";
                break;
            case "nt_fog.gif":
                result = "wi-night-fog";
                break;
            case "nt_hazy.gif":
                result = "wi-day-haze";
                break;
            case "nt_mostlycloudy.gif":
                result = "wi-cloudy";
                break;
            case "nt_mostlysunny.gif":
            case "nt_partlysunny.gif":
            case "nt_partlycloudy.gif":
            case "nt_cloudy.gif":
                result = "wi-night-alt-cloudy";
                break;
            case "nt_sleet.gif":
            case "nt_chancesleet.gif":
                result = "wi-night-alt-sleet";
                break;

            default:
                System.err.println("Unknown weather icon found: " + wundergroundIcon);
        }

        return result;
    }
}
