/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import math.message.TopicExchange;
import math.resource.user;

/**
 *
 * @author i_am-
 */
@Path("intent")
public class IntentOperation {
    Gson gson = new Gson();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  String getHtml() throws IOException, TimeoutException {
    TopicExchange.declareExchange();
    TopicExchange.declareQueues();
    TopicExchange.declareBindings();
    //TopicExchange.subscribeMessage();
    
    String m = TopicExchange.setQ("userIntent");
    System.out.println(m);
            
    return ("Intetn user info: " + m);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIntent( String a) throws IOException, TimeoutException
    {
      
     String random_int = Random.getRandom();
     //create user object
     user userID = new user();
     userID.setUserID(random_int);
     List list = new ArrayList();
     list.add(userID);
     list.add(a);
     String jsonmessage = gson.toJson(list);
     TopicExchange.declareExchange();
     TopicExchange.getPubMessage(jsonmessage, "TRAVEL_INTENT", "userCheck.userIntent");
    return Response.status(201).entity("Intent messaege ID:"+jsonmessage).build();
    }
}
