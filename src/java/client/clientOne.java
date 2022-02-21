/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.google.gson.Gson;
import com.rabbitmq.tools.json.JSONWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import math.resource.tripInfo;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import math.Random;
import math.resource.messageID;

/**
 *
 * @author i_am-
 */
public class clientOne {
    private static Client clientOne = ClientBuilder.newClient();
    
    static Gson gson=new Gson();
 
  public static String doPostInput(String location,String date ) throws IOException {
    URL url = new URL("http://localhost:9090/RESTService_8.2_/webresources/trip");
    //declair trip info
    tripInfo tripIn = new tripInfo(location,date);
    
    String jsonmessage = gson.toJson(tripIn);
    HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
    httpConnection.setDoOutput(true);
    httpConnection.setRequestMethod("POST");
    httpConnection.setRequestProperty("Content-Type", "application/json");
    httpConnection.setRequestProperty("Accept", "application/json");
    DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
    wr.write(jsonmessage.toString().getBytes());
    Integer responseCode = httpConnection.getResponseCode();
      
    BufferedReader bufferedReader;

     // Creates a reader buffer
    if (responseCode > 199 && responseCode < 300) {
        bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
    } else {
        bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
    }

    // To receive the response
    StringBuilder content = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        content.append(line).append("\n");
    }
    bufferedReader.close();

    // Prints the response
    System.out.println(content.toString());
    String e = content.toString();
    return e;
    
}  
    
 //////////////////////////////////////////////////////////////////////////////////////////   
    public static String doGet(URL url) throws IOException{
        HttpURLConnection conn  = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
        (conn.getInputStream())));

        String output;
        System.out.println("\n");
        while ((output = br.readLine()) != null) {
                System.out.println(output);
		}

		conn.disconnect();
                return output;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    public static String doPostIn() throws MalformedURLException, IOException
    {
        URL urlIn = new URL("http://localhost:9090/RESTService_8.2_/webresources/intent");
    
    int me_id = (int)(Math.random() * (20 + 1+1)+1);
    String sMID=Integer.toString(me_id);
    messageID inOne=new messageID("I"+sMID);
    String jsonmessage = gson.toJson(inOne);
     HttpURLConnection httpConnection  = (HttpURLConnection) urlIn.openConnection();
    httpConnection.setDoOutput(true);
    httpConnection.setRequestMethod("POST");
    httpConnection.setRequestProperty("Content-Type", "application/json");
    httpConnection.setRequestProperty("Accept", "application/json");
    DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
    wr.write(jsonmessage.toString().getBytes());
    Integer responseCode = httpConnection.getResponseCode();
      
    BufferedReader bufferedReader;

     // Creates a reader buffer
    if (responseCode > 199 && responseCode < 300) {
        bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
    } else {
        bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
    }

    // To receive the response
    StringBuilder content = new StringBuilder();
    String line;
    while ((line = bufferedReader.readLine()) != null) {
        content.append(line).append("\n");
    }
    bufferedReader.close();

    // Prints the response
    System.out.println(content.toString());
    String e=content.toString();
    return e;
    }
    
    public static void writerF(List<String>outputF) throws IOException
    {
        File file = new File("..\\RESTService(8.2)\\src\\java\\client\\ClientPost.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        for (String str :outputF) {
            fw.write(str +System.lineSeparator());
            //bw.write(str +System.lineSeparator());
        }
        fw.close();
    }
    
        public static void writerI(List<String>outputF) throws IOException
    {
        File file = new File("..\\RESTService(8.2)\\src\\java\\client\\ClientIntent.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        for (String str :outputF) {
            fw.write(str +System.lineSeparator());
        }
        fw.close();
    }
 
    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    public static String doGetIn() throws MalformedURLException, IOException
    {
        URL urlIn = new URL("http://localhost:9090/RESTService_8.2_/webresources/intent");
         HttpURLConnection conn  = (HttpURLConnection) urlIn.openConnection();
        conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");
        BufferedReader br = new BufferedReader(new InputStreamReader(
        (conn.getInputStream())));

        String output;
        System.out.println("\n");
        while ((output = br.readLine()) != null) {
                System.out.println(output);
		}

		conn.disconnect();
                return output;
    }
    

       
    public static void main(String[] args) throws MalformedURLException, IOException {
         URL url = new URL("http://localhost:9090/RESTService_8.2_/webresources/trip/");
          List<String> outputF=new ArrayList();
          List<String> outputI=new ArrayList();
 while (true){
         
        //gretting
        System.out.print("Hello! Welcome to tripAdvertise \n");
        
        
        System.out.print("\n Please type 'P' if you want to post trip advertisement and 'G' if you want to get trip information: " );
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String inputU=input.toUpperCase();
      
        if (inputU.equals("P")){
            System.out.print("Input location of the trip:  " );
            String location = in.nextLine();
            System.out.print("Input date of the trip in YYYY-MM-DD fomate:  " );
            String date = in.nextLine();
            String P=doPostInput(location,date); 
            outputI.add(P);
           
            System.out.print("[x]Wait for intent:   " );
            String inp2 = in.nextLine();
            
            String GI=doGetIn();
            outputI.add(GI);
            writerI(outputI);
            break;}
        
             
            
            
        
        else if (inputU.equals("G"))
        {   String G = doGet(url);
            outputF.add(G);
            System.out.print("\n Are your interested in this advertisement (Y/N): ");
             Scanner in2 = new Scanner(System.in);
            String inp2 = in.nextLine();
            String input2=inp2.toUpperCase();
            if (input2.equals("Y"))
            {
                String PI=doPostIn();
                outputF.add(PI);
                writerF(outputF);
                break;
            }
            else if (input2.equals("N")){System.out.print("\n Bye!");}
            else{ 
                System.out.print("\n Wrong input. Please try again");}
        
        
        }
        else {
            System.out.print("\n Wrong Input, Please Try Again");
        }
        
        
 }
    
    
    
}
}