package com.api.bingmapRESTstyle.util.factory;

import com.api.bingmapRESTstyle.util.BingMapUtil;

public class BingMapUtilFactory {
	
	private static BingMapUtil utilInstance;
	
	  public static BingMapUtil getBingMapUtilInstance() {
	    if(utilInstance == null){
	      utilInstance = new BingMapUtil();
	    }
	    return utilInstance;
	  }
}
