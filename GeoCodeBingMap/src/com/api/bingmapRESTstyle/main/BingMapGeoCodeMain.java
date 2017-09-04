package com.api.bingmapRESTstyle.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.bingmapRESTstyle.model.Address;
import com.api.bingmapRESTstyle.view.BingMapImageBuilder;

/**
 * Servlet implementation class BingMapGeoCodeMain
 */

public class BingMapGeoCodeMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BingMapGeoCodeMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Address address = new Address();
		address.setStreetAdreess(request.getParameter("streetAddress"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipCode"));
		address.setCountry(request.getParameter("country"));
		new BingMapImageBuilder().populateBingMapImage(response,new BingMapGeocodeFetcher().getBingMapImage(address));
	}
}
