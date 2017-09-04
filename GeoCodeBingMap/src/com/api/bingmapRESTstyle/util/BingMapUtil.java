/**
 * 
 */
package com.api.bingmapRESTstyle.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.api.bingmapRESTstyle.model.Address;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author rpanigrahy001
 *
 */
public class BingMapUtil {
	
	/*
	   * this coordinateBuilderMap() used to wrap the Latitude and Longitude into a single map based coordinate object.
	   */
	public Map<String,String> coordinateBuilderMap(JsonNode varLatLong) {
		Map<String,String> coordinateMap = new HashMap();
	    coordinateMap.put("Latitude", varLatLong.get(0).toString());
	    coordinateMap.put("Longitude", varLatLong.get(1).toString());
	    return coordinateMap;
	  }
	
	  /*
	   * this addressBuilderMap() used to wrap the various address fields into a single map based address object.
	   */
	public Map<String,String> addressBuilderMap(Address address) {
		Map<String,String> addressMap = new HashMap();
	    addressMap.put("StreetAdreess", address.getStreetAdreess());
	    addressMap.put("City",address.getCity());
	    addressMap.put("State",address.getState());
	    addressMap.put("ZipCode",address.getZipCode());
	    addressMap.put("Country",address.getCountry());
	    addressMap.put("ResponseType","json");
	    return addressMap;
	  }

	  /*
	   * this encodeString() used to encode
	   * street address, city, state, country and zipCode
	   */
	  public String encodeString(String str) throws UnsupportedEncodingException {
	    return URLEncoder.encode(str.replace(".", "").replace(",", "").replace(":", ""), "UTF-8");
	  }

	  /*
	     * this isNullCheck() used to check the null value for the incoming Objects
	     */
	  public Object isNullCheck(Object input ) {
	    if(input == null)
	      throw new NullPointerException();
	    else
	      return input;
	  }

}
