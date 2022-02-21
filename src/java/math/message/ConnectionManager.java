/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.message;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author i_am-
 */
public class ConnectionManager {
     private static Connection connection = null;
  private static enum EXCHANGE_TYPE {DIRECT, FANOUT, TOPIC, HEADERS};

  
  public static Connection getConnection() throws IOException, TimeoutException
  {
      if (connection == null){
          ConnectionFactory connectionFactory = new ConnectionFactory();
          //connectionFactory.setHost("localhost");
          connection = connectionFactory.newConnection();
          
      }
      return connection;
  }
}
