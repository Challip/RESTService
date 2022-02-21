/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import math.message.TopicExchange;
import math.resource.messageID;
import math.resource.tripInfo;
import math.resource.user;

/**
 *
 * @author i_am-
 */
@Path("trip")
public class TripOperation {
    @Context
    private UriInfo context;
    
    
     Gson gson = new Gson();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    
    
    public  String getHtml() throws IOException, TimeoutException {
    TopicExchange.declareExchange();
    TopicExchange.declareQueues();
    TopicExchange.declareBindings();
    //TopicExchange.subscribeMessage();
    
    String m = TopicExchange.setQI("query");
    System.out.println(m);
            
    return ("trip info" + m);
    }
    
  
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postTrip( String a) throws IOException, TimeoutException
    {
      
     String random_int = Random.getRandom();
     //generate randome number form HTTPconnection for user ID
     user userID = new user();
     userID.setUserID(random_int);
     //generate message ID
    int me_id = (int)(Math.random() * (20 + 1+1)+1);
    String sMID=Integer.toString(me_id);
    messageID one=new messageID("P"+sMID);
    //get location and date from user input, String a
    tripInfo tt =gson.fromJson(a,tripInfo.class);
    String location = tt.getLocation();
    String date = tt.getDate();
    //get weather forecast
    String w =weatherForecast.getForecast(location, date);
     //list for publish to queue
     List list = new ArrayList();
     list.add(userID);
     list.add(one);
     list.add(a);
     String mes= gson.toJson(list);
     TopicExchange.declareExchange();
     //publish to trip queue
     TopicExchange.getPubMessage(mes, "TRAVEL_OFFERS", "trip.");
    List Wlist = new ArrayList();
     Wlist.add(userID);
     Wlist.add(one);
     Wlist.add(a);
     Wlist.add(w);
     String Wmes= gson.toJson(Wlist);
     //publish to query queue
     TopicExchange.getPubMessage(Wmes, "TRAVEL_OFFERS", "query.");
     
     return Response.status(201).entity("trip is: "+a.toString()).build();
   
    }
    
  
    

}
