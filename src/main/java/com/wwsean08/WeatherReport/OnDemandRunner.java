package com.wwsean08.WeatherReport;

import com.google.gson.Gson;
import com.rabbitmq.client.*;
import com.wwsean08.WeatherReport.pojo.Config;
import com.wwsean08.WeatherReport.pojo.RabbitMQJson;
import com.wwsean08.WeatherReport.pojo.wunderground.WUnderground;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wwsea_000 on 12/31/2015.
 */
public class OnDemandRunner implements Runnable
{
    Channel channel;
    final Config config;
    final ExecutorService exec = Executors.newSingleThreadExecutor();

    public OnDemandRunner(Config config) throws Exception
    {
        this.config = config;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(config.getRabbitmqUser());
        factory.setPassword(config.getRabbitmqPassword());
        factory.setHost(config.getRabbitmqServer());
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public void run()
    {
        System.out.println("Initiating on-demand update");
        try
        {
            String queueName = channel.queueDeclare().getQueue();
            channel.queueBind(queueName, "amq.topic", "update");
            Consumer consumer = new DefaultConsumer(channel)
            {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException
                {
                    try
                    {
                        Runnable runner = new WeatherRunner(config);
                        exec.submit(runner);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            channel.basicConsume(queueName, true, consumer);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
