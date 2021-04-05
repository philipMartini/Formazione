package org.advancia.filippo;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class IpLocationFinder {

	public IpLocationFinder() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		
			String ipAddressUS = "216.58.198.46";
			String ipAddressUK = "212.58.251.195";
			//Qui utilizziamo lo stub generato con wsimport
			GeoIPService ipService = new GeoIPService();
			//Questo è lo stub da chiamare per effettuare la chiamata al WS
			GeoIPServiceSoap geoIpServiceSoap = ipService.getGeoIPServiceSoap();
			String location = geoIpServiceSoap.getIpLocation(ipAddressUK);
			System.out.println("You Location IS: " + location);
		
	}

}
