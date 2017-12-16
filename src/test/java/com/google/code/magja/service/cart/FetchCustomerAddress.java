package com.google.code.magja.service.cart;

import java.util.List;

import com.google.code.magja.model.customer.CustomerAddress;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerAddressRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.util.ObjectFactory;
import com.google.gson.Gson;

public class FetchCustomerAddress {
	public static void main(String[] args) throws Exception{
		String apiUser = "rahul";
		String apiKey = "agile@123";
		String remoteHost = "http://192.168.1.241:81/magento/api/soap/";

		SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = (MagentoSoapClient) MagentoSoapClient.getInstance(soapConfig);
		final RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);

		CustomerAddressRemoteService customerAddressRemoteService = remoteServiceFactory.getCustomerAddressRemoteService();
		
		
		CustomerAddress shipAddr = null;
		CustomerAddress billAddr = null;
		List<CustomerAddress> customerAddresses=customerAddressRemoteService.list(7);
		for (CustomerAddress customerAddress : customerAddresses) {
			    shipAddr=customerAddress;
		    	billAddr=customerAddress;
			    shipAddr.setDefaultBilling(false);
			    shipAddr.setDefaultShipping(true);
			    billAddr.setDefaultBilling(true);
			    billAddr.setDefaultShipping(false);		  
		     //ystem.out.println(new Gson().toJson(customerAddress.serializeToApi()));
		     //customerAddressRemoteService.save(customerAddress);
		}
		
		
		
		

	}
}
