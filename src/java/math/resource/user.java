/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.resource;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.Charset;
import javax.annotation.Generated;
@Generated("jsonschema2pojo")
public class user {
 @SerializedName("uerID")
@Expose
private String uerID;


public String getUserID() {
return uerID;
}

public void setUserID(String uerID) {
this.uerID = uerID;
}

@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(user.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("uerID");
sb.append('=');
sb.append(((this.uerID == null)?"<null>":this.uerID));
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}   

}
