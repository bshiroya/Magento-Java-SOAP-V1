package com.google.code.magja.service.cart;

import java.util.List;
import java.util.Map;

import com.google.code.magja.magento.ResourcePath;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;

public class GetShipment {
	public static void main(String[] args) throws Exception {

		String apiUser = "rahul";
	    String apiKey = "agile@123";
	    String remoteHost = "http://192.168.1.241:81/magento/api/soap/";
	    
	    SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
	    MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
	   // RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
	   // ShipmentRemoteService shipmentRemoteService=remoteServiceFactory.getShipmentRemoteService();
	    
	   // List<Map<String, Object>> remote_list = null;
	   // remote_list = (List<Map<String, Object>>) magentoSoapClient.callSingle(ResourcePath.ShoppingCartSetShippingInfo,new Object[] {81,"flatrate_flatrate"});
	    
	    
	    Boolean success = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartSetShippingInfo, new Object[] {81,"flatrate_flatrate"});
		  
	}
}
