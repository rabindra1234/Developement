/**
 * 
 */
package com.api.bingmapRESTstyle.model;

/**
 * @author rpanigrahy001
 *
 */
public class Address {
	
	private static String StreetAdreess;
	private static  String City;
	private static String State;
	private static String ZipCode;
	private static String Country;
	
	public static String getStreetAdreess() {
		return StreetAdreess;
	}
	public static void setStreetAdreess(String streetAdreess) {
		StreetAdreess = streetAdreess;
	}
	public static String getCity() {
		return City;
	}
	public static void setCity(String city) {
		City = city;
	}
	public static String getState() {
		return State;
	}
	public static void setState(String state) {
		State = state;
	}
	public static String getZipCode() {
		return ZipCode;
	}
	public static void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public static String getCountry() {
		return Country;
	}
	public static void setCountry(String country) {
		Country = country;
	}
}
