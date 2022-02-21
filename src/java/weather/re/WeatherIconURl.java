/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.re;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class WeatherIconUrl {

@SerializedName("value")
@Expose
private String value;

public String getValue() {
return value;
}

public void setValue(String value) {
this.value = value;
}

}