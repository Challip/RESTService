/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author i_am-
 */
public class Random {
    private static HttpURLConnection connection;  
    
    public static String getRandom() throws MalformedURLException, IOException{
    URL url;
    url = new URL("https://www.random.org/integers/?num=1&min=1000&max=9999&col=1&base=10&format=plain&rnd=new");
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
           String ranNum=responseContent.toString();
           return ranNum;
            
    }
}
