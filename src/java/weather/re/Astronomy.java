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
public class Astronomy {

@SerializedName("sunrise")
@Expose
private String sunrise;
@SerializedName("sunset")
@Expose
private String sunset;
@SerializedName("moonrise")
@Expose
private String moonrise;
@SerializedName("moonset")
@Expose
private String moonset;
@SerializedName("moon_phase")
@Expose
private String moonPhase;
@SerializedName("moon_illumination")
@Expose
private String moonIllumination;

public String getSunrise() {
return sunrise;
}

public void setSunrise(String sunrise) {
this.sunrise = sunrise;
}

public String getSunset() {
return sunset;
}

public void setSunset(String sunset) {
this.sunset = sunset;
}

public String getMoonrise() {
return moonrise;
}

public void setMoonrise(String moonrise) {
this.moonrise = moonrise;
}

public String getMoonset() {
return moonset;
}

public void setMoonset(String moonset) {
this.moonset = moonset;
}

public String getMoonPhase() {
return moonPhase;
}

public void setMoonPhase(String moonPhase) {
this.moonPhase = moonPhase;
}

public String getMoonIllumination() {
return moonIllumination;
}

public void setMoonIllumination(String moonIllumination) {
this.moonIllumination = moonIllumination;
}
}