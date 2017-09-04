package com.api.bingmapRESTstyle.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BingMapImageBuilder {
	
	public void populateBingMapImage(HttpServletResponse response,String imageUri){
		
	try{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><head><title>Bing Map Image</title></head><body><p>https://dev.virtualearth.net/REST/V1/Imagery/Map/Road/42.6564%2C-73.7638/13?mapSize=600,300&format=png&key=YOUR-API-KEY-HERE)</p></body></html>");
        out.flush();
    }catch(IOException ex){
    	System.out.println("Exception Occured in the populatinfg the Bing Map Image" +ex.getMessage());
    }
	}
}
