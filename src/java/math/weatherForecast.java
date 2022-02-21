/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author i_am-
 */

public class weatherForecast {
   private static HttpURLConnection connection;  
   
   public static void storeData(StringBuffer responseContent) throws IOException
   {
       FileWriter file = new FileWriter("..\\RESTService(8.2)\\src\\java\\math\\weatherNew.json"); 
       {
       file.write(responseContent.toString());
       file.close();

   }
   }
   
  public static String getForecast(String location,String date) throws MalformedURLException, IOException{
      
    URL url;
    
    url = new URL("http://api.worldweatheronline.com/premium/v1/weather.ashx?key=dabe67710ff7412d98f04847213012&q="+location+"&format=json&date="+date+"&cc=no&mca=no&fx24=no&includelocation=no&show_comments=no&tp=24&showlocaltime=no&aqi=no");
    //url= new URL("https://www.7timer.info/bin/api.pl?lon=97.909&lat=19.498&product=two&output=json\n");
    connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            int status = connection.getResponseCode();
            //System.out.println(status);
            BufferedReader in;
            String line;
            StringBuffer responseContent = new StringBuffer();
            
            if (status > 299){
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = in.readLine()) != null ){
                    responseContent.append(line);
                }
                in.close();
            }else {
                in= new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = in.readLine()) != null ){
                    responseContent.append(line);
                }
                in.close();
            }
            
           System.out.println(responseContent);
           String wResult=responseContent.toString();
           
       
           //store weather data in file;
           //storeData(responseContent);
           
           
           return wResult;
       }
       ;


}
