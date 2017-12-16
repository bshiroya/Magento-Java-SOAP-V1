package com.connector.magento.soap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.connector.magento.ResourcePath;
import com.google.gson.Gson;



public class MagentoAPI {

//	private static final Logger LOG = Logger.getLogger(RestController.class);

	private static final String CUSTOMER = "Customer";
	private static final String PRODUCT = "Product";
	private static final String INVOICE = "Invoice";
	private static final String SALESORDER = "SalesOrder";

	

	
	

	public static void main(String[] args) throws Exception {
		String apiUser = "rahul";
		String apiKey = "agile@123";
		String remoteHost = "http://192.168.1.241:81/magento/api/soap/?wsdl";
		List<Map<String, Object>> criteriaList = new ArrayList<Map<String, Object>>();
		Map<String, Object> criteria = new HashMap<String, Object>();
		Map<String, Object> step = new HashMap<String, Object>();
		step.put("gteq", "2017-07-06 08:11:00");
		criteria.put("updated_at", step);
		criteriaList.add(criteria);
		SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
		//Object object = magentoSoapClient.call(ResourcePath.SalesOrderList, "");
		Object object  = magentoSoapClient.call(ResourcePath.SalesOrderList, "");
		
		//Object object = MagentoAPI.getSingleRecords(magentoSoapClient, "Payment");
		System.out.println(new Gson().toJson(object));
	}

}
