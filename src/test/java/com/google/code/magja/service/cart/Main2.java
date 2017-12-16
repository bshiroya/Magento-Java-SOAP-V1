package com.google.code.magja.service.cart;

import java.util.List;

import com.google.code.magja.model.cart.Cart;
import com.google.code.magja.model.cart.CartAddress;
import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.model.customer.CustomerAddress;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerAddressRemoteService;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.util.ObjectFactory;

public class Main2 {
public static void main(String[] args) throws Exception {

	String apiUser = "rahul";
    String apiKey = "agile@123";
    String remoteHost = "http://192.168.1.241:81/magento/api/soap/";
    
    
    SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
    MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
    RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
    System.out.println("call1");
    
    CartRemoteService  service = remoteServiceFactory.getCartRemoteService();;
    CustomerRemoteService customerService = remoteServiceFactory.getCustomerRemoteService();
    CustomerAddressRemoteService  customerAddressService = remoteServiceFactory.getCustomerAddressRemoteService();
    ProductRemoteService productService = remoteServiceFactory.getProductRemoteService();
    
    System.out.println("call2");
    
 //   remoteServiceFactory.getS
    
    Product product=null;
    List<Product> products = remoteServiceFactory.getProductRemoteService().listAll();
	if(products!=null && products.size()>0){
		product=products.get(0);
	}
	
	System.out.println("call3");
    
	
/*      Customer customer = ObjectFactory.generateCustomer();
	    customer.setStoreId(1);
	    customer.setEmail("abcd@gmail.com");
	    System.out.println(customer.getEmail()+"----------AA----------------");
	    customerService.save(customer);

	    CustomerAddress shipAddr = ObjectFactory.generateAddress();
	    CustomerAddress billAddr = ObjectFactory.generateAddress();
	    shipAddr.setCustomer(customer);
	    shipAddr.setDefaultBilling(false);
	    shipAddr.setDefaultShipping(true);
	    billAddr.setCustomer(customer);
	    billAddr.setDefaultBilling(true);
	    billAddr.setDefaultShipping(false);*/
	    
    /*
     * First Create Customer
     */
	
	Customer customer=remoteServiceFactory.getCustomerRemoteService().getById(6);
   // Customer customer = ObjectFactory.generateCustomer();
	//customerService.save(customer);
	
	System.out.println("call4");
	
	
	CustomerAddress shipAddr = null;
	CustomerAddress billAddr = null;
	    
	List<CustomerAddress> customerAddresses=remoteServiceFactory.getCustomerAddressRemoteService().list(6);
	if(customerAddresses!=null){
	  for (CustomerAddress customerAddress : customerAddresses) {
		  shipAddr=customerAddress;
		  billAddr=customerAddress;
	  }
	}
	
    //CustomerAddress shipAddr = ObjectFactory.generateAddress();
    //CustomerAddress billAddr = ObjectFactory.generateAddress();
    shipAddr.setCustomer(customer);
    shipAddr.setDefaultBilling(false);
    shipAddr.setDefaultShipping(true);
    billAddr.setCustomer(customer);
    billAddr.setDefaultBilling(true);
    billAddr.setDefaultShipping(false);

    
    System.out.println("call78");
    
/**
 * Second save bill and shippinh address
 */
 //   customerAddressService.save(shipAddr);
 //   customerAddressService.save(billAddr);

    System.out.println("call5");
    /*
     * Create cart
     */
    Cart cart = service.create(1);
    
    System.out.println("call456---------------------"+cart.getId());
    cart.setCustomer(customer);
  
    
    service.setCustomer(cart);
  
    System.out.println("call6");

    /*service.addProduct(cart, product, 1);

    System.out.println("call7");
    
    CartAddress cartShipAddr = CartAddress.fromAttributes(shipAddr.getAllProperties());
    CartAddress cartBillAddr = CartAddress.fromAttributes(billAddr.getAllProperties());
    cart.setBillingaddress(cartBillAddr);
    cart.setShippingAddress(cartShipAddr);
    service.setAddresses(cart);


    service.order(cart);*/
    
}
}
