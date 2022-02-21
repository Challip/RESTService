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
public class Request {

@SerializedName("type")
@Expose
private String type;
@SerializedName("query")
@Expose
private String query;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getQuery() {
return query;
}

public void setQuery(String query) {
this.query = query;
}

}