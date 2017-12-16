package com.google.code.magja.service.cart;

import java.util.List;

import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.model.customer.CustomerAddress;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerAddressRemoteService;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;


public class WyfStaging {
	public static void main(String[] args) throws Exception {

		Product product=null;
		RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(MagentoSoapClient.getInstance());
		
		CustomerRemoteService customerService=remoteServiceFactory.getCustomerRemoteService();
		CartRemoteService service = remoteServiceFactory.getCartRemoteService();
		CustomerAddressRemoteService customerAddressService = remoteServiceFactory.getCustomerAddressRemoteService();
		ProductRemoteService productService = remoteServiceFactory.getProductRemoteService();
		
		
		
		
		Customer customer=customerService.getById(7249);		
		System.out.println(customer.getFirstName());
		
		List<CustomerAddress> customerAddresses=customerAddressService.list(7249);
		for (CustomerAddress customerAddress : customerAddresses) {
			System.out.println(customerAddress.getDefaultShipping());
			System.out.println(customerAddress.getDefaultBilling());
		}
		
	//	service.getById(id, storeId)
		
		
		  /*  Map<String, Object> hashMapProperties = new HashMap<String, Object>();
		    Integer v=null;
		    hashMapProperties.put("customer_id",v);
		    hashMapProperties.put("firstname", "Sergio");
		    hashMapProperties.put("middlename", "Miguel");
		    hashMapProperties.put("lastname", "Gomes");
		    hashMapProperties.put("email", "gomesss1@tes23tse.pt");
		    hashMapProperties.put("password_hash", "iqfqifiuqwf");
		    hashMapProperties.put("store_id", 1);
		    hashMapProperties.put("website_id", 1);
		    hashMapProperties.put("group_id", 1);
		    hashMapProperties.put("created_at", new Date().toString());
		    
	       Integer id = Integer.parseInt((String) MagentoSoapClient.getInstance().callSingle(ResourcePath.CustomerCreate, hashMapProperties));
*/
	/*	Customer customer = ObjectFactory.generateCustomer();
	    customerService.save(customer);*/

	    /*CustomerAddress shipAddr = ObjectFactory.generateAddress();
	    CustomerAddress billAddr = ObjectFactory.generateAddress();
	    shipAddr.setCustomer(customer);
	    shipAddr.setDefaultBilling(false);
	    shipAddr.setDefaultShipping(true);
	    billAddr.setCustomer(customer);
	    billAddr.setDefaultBilling(true);
	    billAddr.setDefaultShipping(false);

	  
	    customerAddressService.save(shipAddr);
	    customerAddressService.save(billAddr);


	    Cart cart = service.create(0);



	    cart.setCustomer(customer);
	    service.setCustomer(cart);


	    service.addProduct(cart, product, 1);


	    CartAddress cartShipAddr = CartAddress.fromAttributes(shipAddr.getAllProperties());
	    CartAddress cartBillAddr = CartAddress.fromAttributes(billAddr.getAllProperties());
	    cart.setBillingaddress(cartBillAddr);
	    cart.setShippingAddress(cartShipAddr);
	    service.setAddresses(cart);

	    service.order(cart);
		
		*/
		
		
		
		/*Customer cust = service.getById(7247);
		
		if(cust!=null){
			System.out.println(cust.getFirstName());
		}*/
		
		/*String apiUser = "bhadresh";
	    String apiKey = "agile@123";
	    String remoteHost = "http://staging.warmyourfloor.com/api/soap/";
	
	    
	    
	     SoapConfig soapConfig = new SoapConfig(apiUser, apiKey,remoteHost);
	     MagentoSoapClient magentoSoapClient = (MagentoSoapClient) MagentoSoapClient.getInstance(soapConfig); */
	     
		/*SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
		RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
		*/
		
		/*SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
		RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
		magentoSoapClient.setConfig(soapConfig);

		
	    CustomerRemoteService customerRemoteService=remoteServiceFactory.getCustomerRemoteService();
	    
	    Customer cus=customerRemoteService.getById(7247);
	    
	    System.out.println("FirstName :"+cus.getFirstName());*/
		  System.out.println("call");   
	}
}
