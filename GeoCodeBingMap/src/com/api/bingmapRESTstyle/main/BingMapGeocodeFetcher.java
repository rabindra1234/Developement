/**
 * 
 */
package com.api.bingmapRESTstyle.main;

import java.io.IOException;

import com.api.bingmapRESTstyle.URI.BingMapRESTURIFormatter;
import com.api.bingmapRESTstyle.client.BingMapRESTClientInvoker;
import com.api.bingmapRESTstyle.model.Address;
import com.api.bingmapRESTstyle.util.BingMapUtil;
import com.api.bingmapRESTstyle.util.factory.BingMapUtilFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rpanigrahy001
 *
 */
public class BingMapGeocodeFetcher implements IBingMapGeoCodeRESTInvoker {

	  /*
	      * this getBingMapImage() used to invoke the exposed Bing Map REST Services.
	      */
	public String getBingMapImage(Address address) {
	    BingMapUtil utilCaller = BingMapUtilFactory.getBingMapUtilInstance();
	    BingMapRESTClientInvoker clientInvokerInstance = new BingMapRESTClientInvoker();
	    BingMapRESTURIFormatter urlFormatterInstance= new BingMapRESTURIFormatter();
	    ObjectMapper objectMapper = new ObjectMapper();
	    JsonNode rootNode;
	    String imageURI=new String();
	      try {
	    	String dynamicURI = urlFormatterInstance.prepareDynamicLocationAPIURL(utilCaller.addressBuilderMap(address));
	    	byte[]  jsonResponseData= (utilCaller.isNullCheck(clientInvokerInstance.getResultHttpAsStream(dynamicURI)).toString()).getBytes();
	        rootNode = objectMapper.readTree(jsonResponseData);
	        imageURI = urlFormatterInstance.prepareDynamicImageryAPIURL(utilCaller.coordinateBuilderMap(rootNode.findPath("geocodePoints").findValue("coordinates")));
	      } catch (IOException ex) {
	      }
	      catch (Exception ex) {
	      }
	      return imageURI;
	    }
	}