/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import math.message.TopicExchange;

/**
 *
 * @author i_am-
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        TopicExchange.declareExchange();
    TopicExchange.declareQueues();
    TopicExchange.declareBindings();
    }
    
}
