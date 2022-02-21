/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math.resource;

/**
 *
 * @author i_am-
 */
public class tripInfo {
   
    private String location;
    private String date;
    


    public tripInfo(String location, String date) {
        
        this.location = location;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
    
   
@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append(tripInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
sb.append("location");
sb.append('=');
sb.append(((this.location == null)?"<null>":this.location));
sb.append(',');
sb.append("date");
sb.append('=');
sb.append(((this.date == null)?"<null>":this.date));
sb.append(',');
if (sb.charAt((sb.length()- 1)) == ',') {
sb.setCharAt((sb.length()- 1), ']');
} else {
sb.append(']');
}
return sb.toString();
}

}
  


    

