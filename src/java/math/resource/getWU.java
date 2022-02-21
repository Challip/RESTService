/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.resource;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class getWU {
@SerializedName("date")
@Expose
private String date;
@SerializedName("location")
@Expose
private String location;
@SerializedName("messageID")
@Expose
private String messageID;


public getWU(String date, String location, String messageID) {
super();
this.date = date;
this.location = location;
this.messageID = messageID;
}
public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public String getMessageID() {
return messageID;
}

public void setMessageID(String messageID) {
this.messageID = messageID;
}
}
