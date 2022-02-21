/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.message;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class TopicExchange {
  /**
   * Declare a Topic Exchange with the name my-topic-exchange.
   *
   * @throws IOException
   * @throws TimeoutException
   */
  public static void declareExchange() throws IOException, TimeoutException {
    Channel channel = ConnectionManager.getConnection().createChannel();
    //Create Topic Exchange
    channel.exchangeDeclare("TRAVEL_OFFERS", BuiltinExchangeType.TOPIC, true);
    channel.exchangeDeclare("TRAVEL_INTENT", BuiltinExchangeType.TOPIC, true);
    //channel.close();
  }
 

  /**
   * Declare Queues to receive respective interested messages.
   *
   * @throws IOException
   * @throws TimeoutException
   */
  public static void declareQueues() throws IOException, TimeoutException {
    //Create a channel - do not share the Channel instance
    Channel channel = ConnectionManager.getConnection().createChannel();

    //Create the Queues
    channel.queueDeclare("trip", true, false, false, null);
    //channel.queueDeclare("user", true, false, false, null);
    channel.queueDeclare("query", true, false, false, null);
    channel.queueDeclare("userIntent", true, false, false, null);
    channel.queueDeclare("userCheck", true, false, false, null);

    

    channel.close();
  }

  /**
   * Declare Bindings - register interests using routing key patterns.
   *
   * @throws IOException
   * @throws TimeoutException
   */
  public static void declareBindings() throws IOException, TimeoutException {
    Channel channel = ConnectionManager.getConnection().createChannel();
    //Create bindings#
    //channel.queueBind("user", "TRAVEL_OFFERS", "user.*");
    channel.queueBind("trip", "TRAVEL_OFFERS", "trip.*");
    channel.queueBind("query", "TRAVEL_OFFERS", "query.*");
    channel.queueBind("userIntent", "TRAVEL_INTENT", "#.userIntent");
    channel.queueBind("userCheck", "TRAVEL_INTENT", "userCheck.*");
    channel.close();
  }

 
  ///////////////////////////////////////////////////////////////////////////
   public static String setQ(String queue ) throws IOException, TimeoutException
   {
    Channel channel = ConnectionManager.getConnection().createChannel();
    
    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
    String message = new String(delivery.getBody(), "UTF-8");
    System.out.println(" [x] Received '" + message + "'");
    
    };

    String m =channel.basicConsume(queue, true, deliverCallback, consumerTag -> {}) ;
    

            
     return m;
    }
   ////////////////////////////////////////////////////////////////////////
   
///////////////////////////////////////////////////////////////////////////
    public static String setQI(String queue ) throws IOException, TimeoutException
   {
    Channel channel = ConnectionManager.getConnection().createChannel();

    
    GetResponse resp = channel.basicGet(queue, false);
            if( resp != null ){
                String message = new String(resp.getBody(), "UTF-8");
                System.out.println(" [x] Received resp '" + message + "'");
                channel.basicAck(resp.getEnvelope().getDeliveryTag(), false);
                return message;
            }
            else
            return "Queue Emty";
            
    }
  
  //////////////////////////////////////////////////////////////////////////////////
  
    public static String getPubMessage(String message,String Exchange,String topic_key) throws IOException, TimeoutException {
       try (Channel channel = ConnectionManager.getConnection().createChannel()){
    //String message = "Drink a lot of Water and stay Healthy!";
    channel.basicPublish(Exchange, 
                    topic_key,
                    new AMQP.BasicProperties.Builder()
                        .contentType("application/json")
                        .deliveryMode(2)
                        .priority(1)
                        .userId("guest")
                        //.expiration("60000")
                        .build(),
                    message.getBytes(StandardCharsets.UTF_8));
            return message;
    //channel.close();
    }}
       

  


  /**
   * Execute the methods.
   *
   * @param args
   * @throws IOException
   * @throws TimeoutException
   */

}

