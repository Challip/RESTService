/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weather.re;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

@SerializedName("request")
@Expose
private List<Request> request = null;
@SerializedName("weather")
@Expose
private List<Weather> weather = null;

public List<Request> getRequest() {
return request;
}

public void setRequest(List<Request> request) {
this.request = request;
}

public List<Weather> getWeather() {
return weather;
}

public void setWeather(List<Weather> weather) {
this.weather = weather;
}

}