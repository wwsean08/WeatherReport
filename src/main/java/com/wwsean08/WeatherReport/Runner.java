package com.wwsean08.WeatherReport;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.wwsean08.WeatherReport.pojo.RabbitMQJson;
import com.wwsean08.WeatherReport.pojo.wunderground.WUnderground;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by wwsea_000 on 12/30/2015.
 */
public class Runner implements Runnable
{
    Channel channel;
    String endpoint;

    public Runner() throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("10.0.0.142");
        Connection connection = factory.newConnection();
        channel = connection.createChannel();

        endpoint = "http://api.wunderground.com/api/" + Key.getKEY() + "/conditions/q/WA/Seattle.json";
    }

    public void run()
    {
        try
        {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(endpoint);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String responseString = EntityUtils.toString(response.getEntity());
            byte[] rabbitMQMessage = getRabbitMQMessage(responseString);
            response.close();
            httpClient.close();

            //Send the message to rabbitmq
            channel.basicPublish("amq.topic", "weather", null, rabbitMQMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private byte[] getRabbitMQMessage(String response)
    {
        byte[] result = null;
        Gson GSON = new Gson();
        WUnderground wunderground = GSON.fromJson(response, WUnderground.class);
        RabbitMQJson json = new RabbitMQJson();
        json.setIcon(wunderground.getIconURL());
        json.setLocation(wunderground.getLocation());
        json.setTemp(wunderground.getTemp());

        result = GSON.toJson(json).getBytes();
        return result;
    }
}