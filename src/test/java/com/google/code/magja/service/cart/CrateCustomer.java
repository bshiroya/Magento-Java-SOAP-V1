package com.google.code.magja.service.cart;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import com.google.code.magja.magento.ResourcePath;
import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.model.customer.Customer.Gender;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.ServiceException;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.utils.MagjaStringUtils;

public class CrateCustomer {
	public static void main(String[] args) throws ServiceException, NumberFormatException, AxisFault {
		
		
		String apiUser = "rahul";
		String apiKey = "agile@123";
		String remoteHost = "http://192.168.1.241:81/magento/api/soap/";


	     SoapConfig soapConfig = new SoapConfig(apiUser, apiKey,remoteHost);
	     MagentoSoapClient magentoSoapClient = (MagentoSoapClient) MagentoSoapClient.getInstance(soapConfig);     

	     /*final RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
	     
	     CustomerRemoteService customerService=remoteServiceFactory.getCustomerRemoteService();
	     
	     Customer cust = new Customer();
	     cust.setFirstName("MYJAMES"+MagjaStringUtils.randomString(5, 10));
	     cust.setMiddleName(MagjaStringUtils.randomString(5, 10));
	     cust.setLastName(MagjaStringUtils.randomString(5, 10));
	     cust.setPassword("test12");
	     cust.setPrefix("Mr.");
	     cust.setWebsiteId(1);
	     cust.setGroupId(1);
	     cust.setGender(Gender.MALE);
	     String email = MagjaStringUtils.randomString(4, 5) + "@" + MagjaStringUtils.randomString(4, 5) + ".com";
	     cust.setEmail(email.toLowerCase());
	     cust.set("dob", "1980-08-17 20:53:04");

	     customerService.save(cust);*/
		    
		    /**
		     * Working
		     */
		  /*  Map<String, Object> hashMapProperties = new HashMap<String, Object>();
		    Integer v=null;
		    hashMapProperties.put("customer_id",v);
		    hashMapProperties.put("firstname", "kavita");
		    hashMapProperties.put("middlename", "Miguel");
		    hashMapProperties.put("lastname", "Gomes");
		    hashMapProperties.put("email", "raju@tes23sssstse.pt");
		    hashMapProperties.put("password", "iqfqifiuqwf");
		    hashMapProperties.put("store_id", 1);
		    hashMapProperties.put("website_id", 1);
		    hashMapProperties.put("gender", 2);
		    hashMapProperties.put("group_id", 1);
		    hashMapProperties.put("created_at", new Date().toString());
		    
	        Integer id = Integer.parseInt((String) magentoSoapClient.callSingle(ResourcePath.CustomerCreate, hashMapProperties));
		    System.out.println(id);*/
		    
	

	}
}
