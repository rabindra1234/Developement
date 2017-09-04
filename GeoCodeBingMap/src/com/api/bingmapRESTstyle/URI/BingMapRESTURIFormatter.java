package com.api.bingmapRESTstyle.URI;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.api.bingmapRESTstyle.constants.BingMapConstants;
import com.api.bingmapRESTstyle.util.BingMapUtil;
import com.api.bingmapRESTstyle.util.factory.BingMapUtilFactory;

public class BingMapRESTURIFormatter {
	
	
	/*
	 * This prepareDynamicImageryAPIURL() prepare URL dynamically by appending
	 * latitude, longitude, mapSize and pushpins as parameter
	 * after the static part of Bing imagery api
	 */
	  public String prepareDynamicImageryAPIURL(Map<String,String> varLatLong) {
		StringBuffer imageAPIBuffer = new StringBuffer();
	    imageAPIBuffer.append(BingMapConstants.BINGIMAGERYURL)
	        .append(BingMapConstants.SLASH);
	    imageAPIBuffer.append(varLatLong.get("Latitude")).append(BingMapConstants.COMMA);
	    imageAPIBuffer.append(varLatLong.get("Longitude")).append(BingMapConstants.SLASH)
	        .append(BingMapConstants.PARAM_MAP_ZOOM_SIZE).append("?")
	        .append(BingMapConstants.PARAM_MAP_PUSHPINS).append(BingMapConstants.EQUAL);
	    imageAPIBuffer.append(varLatLong.get("Latitude")).append(BingMapConstants.COMMA);
	    imageAPIBuffer.append(varLatLong.get("Longitude")).append(BingMapConstants.SEMICOLON).append(BingMapConstants.SEMICOLON)
	        .append(BingMapConstants.PARAM_MAP_PUSHPINS_NAME)
	        .append(BingMapConstants.AND).append(BingMapConstants.PARAM_MAP_SIZE)
	        .append(BingMapConstants.AND).append(BingMapConstants.PARAM_KEY)
	        .append(BingMapConstants.EQUAL)
	        .append(BingMapConstants.BINGAUTHENTICATIONKEY);
	    return imageAPIBuffer.toString();
	  }
	  
	  /*
	   * This prepareDynamicLocationAPIURL() prepare URL dynamically by appending
	   * street address, city, state, country and zipCode as parameter
	   * after the static part of Bing locations api
	   */
	   public String prepareDynamicLocationAPIURL(Map<String,String> addressMap) {
		   StringBuffer locationAPIBuffer = new StringBuffer();
	     BingMapUtil utilCaller = BingMapUtilFactory.getBingMapUtilInstance();
	     locationAPIBuffer.append(BingMapConstants.BINGLOCATIONURL).append("?");
	     locationAPIBuffer.append(BingMapConstants.PARAM_COUNTRY).append(BingMapConstants.EQUAL).append(addressMap.get("Country")).append(BingMapConstants.AND);
	     try {
	       locationAPIBuffer.append(BingMapConstants.PARAM_STATE).append(BingMapConstants.EQUAL).append(utilCaller.encodeString(addressMap.get("State"))).append(BingMapConstants.AND);
	     } catch (UnsupportedEncodingException ex) {
	     }
	     try {
	       locationAPIBuffer.append(BingMapConstants.PARAM_CITY).append(BingMapConstants.EQUAL).append(utilCaller.encodeString(addressMap.get("City"))).append(BingMapConstants.AND);
	     } catch (UnsupportedEncodingException ex) {
	     }
	     locationAPIBuffer.append(BingMapConstants.PARAM_ZIP).append(BingMapConstants.EQUAL).append(addressMap.get("ZipCode")).append(BingMapConstants.AND);
	     try {
	       locationAPIBuffer.append(BingMapConstants.PARAM_ADDRESS).append(BingMapConstants.EQUAL).append(utilCaller.encodeString(addressMap.get("StreetAdreess"))).append(BingMapConstants.AND);
	     } catch (UnsupportedEncodingException ex) {
	     }
	     locationAPIBuffer.append(BingMapConstants.PARAM_KEY).append(BingMapConstants.EQUAL).append(BingMapConstants.BINGAUTHENTICATIONKEY).append(BingMapConstants.AND);
	     locationAPIBuffer.append(BingMapConstants.PARAM_OUTPUT).append(BingMapConstants.EQUAL).append(addressMap.get("ResponseType"));
	     return locationAPIBuffer.toString();
	   }

}
