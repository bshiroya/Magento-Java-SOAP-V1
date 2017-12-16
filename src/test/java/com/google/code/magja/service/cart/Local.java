package com.google.code.magja.service.cart;

import java.util.List;

import com.google.code.magja.model.cart.Cart;
import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.model.customer.CustomerAddress;
import com.google.code.magja.model.customer.Customer.Gender;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerAddressRemoteService;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.utils.MagjaStringUtils;

public class Local {
	public static void main(String[] args) throws Exception {

		String apiUser = "rahul";
		String apiKey = "agile@123";
		String remoteHost = "http://192.168.1.241:81/magento/api/soap/";

		SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
		final RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
		CustomerRemoteService customerService = remoteServiceFactory.getCustomerRemoteService();

		Customer cust = new Customer();

		cust.setFirstName(MagjaStringUtils.randomString(5, 10));
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

		customerService.save(cust);

	}
}
