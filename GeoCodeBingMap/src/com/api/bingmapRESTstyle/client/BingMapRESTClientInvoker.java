/**
 * 
 */
package com.api.bingmapRESTstyle.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author rpanigrahy001
 *
 */
public class BingMapRESTClientInvoker {

	/*
	  * this getResultHttpAsStream() used to invoke Bing Rest-api
	  * using  HttpURLConnection and converting the result in string format
	  */
	 public final String getResultHttpAsStream(String url) 
	 {
	  System.out.println("url = " + url);
	     HttpURLConnection conn = null;
	     BufferedReader rd = null;
	     StringBuffer sb = new StringBuffer();
	  try {
	   URL u = new URL(url);
	   conn = (HttpURLConnection)u.openConnection();
	    
	   if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
	    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    while ((line = rd.readLine()) != null)
	    {
	     sb.append(line);
	    }
	    rd.close();
	   } 
	    
	  } catch (Exception ex) {
		  System.out.println("Exception Occured during invokation of exposed Bing Map the REST Service" +ex.getMessage());
	  } finally{
	   conn = null;
	  }
	  return sb.toString();
	 }
}
