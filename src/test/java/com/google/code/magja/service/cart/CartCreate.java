package com.google.code.magja.service.cart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.code.magja.magento.ResourcePath;
import com.google.code.magja.model.cart.Cart;
import com.google.code.magja.model.cart.CartAddress;
import com.google.code.magja.model.cart.CartAddress.Type;
import com.google.code.magja.model.customer.CustomerAddress;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.customer.CustomerAddressRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;

public class CartCreate {
	public static void main(String[] args) throws Exception{

		String apiUser = "rahul";
	    String apiKey = "agile@123";
	    String remoteHost = "http://192.168.1.241:81/magento/api/soap/";
	    
	    SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
	    MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
	    RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
		CustomerAddressRemoteService customerAddressRemoteService = remoteServiceFactory.getCustomerAddressRemoteService();
		
		CartRemoteService service = remoteServiceFactory.getCartRemoteService();
		
	    System.out.println("Create Connections");
	    
	    int storeId=1;
	    int cutomerId=16;
	    int quantity=1;
	    int productId=4;
	    
	    /**
	     * First Create Cart
	     */
	    
	      Integer id = magentoSoapClient.callSingle(ResourcePath.ShoppingCartCreate, storeId);
	      System.out.println("Cart Created Id:"+id);
	      Cart cart = new Cart();
	      cart.setId(id);
	      cart.setStoreId(storeId);
	     
	      /*
	       * --------------------------------------Customer Set---------------------------------------------------------
	       */
	      
	    	      
	      
	      Map<String, Object> customerProps = new HashMap<String, Object>();
	      customerProps.put("mode", "customer");
	      customerProps.put("customer_id",cutomerId);
	      
	      Map<String, Object> callParams = new HashMap<String, Object>();
	      callParams.put("quoteId", cart.getId());
	      callParams.put("customerData", customerProps);
	      callParams.put("store", cart.getStoreId());
	      
	      List<Object> params = new LinkedList<Object>();
	      params.add(cart.getId());
	      
	      
	      Boolean success1 = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartCustomerSet, new Object[] { cart.getId(),customerProps});
	      System.out.println("Set Cutomer In Cart result:"+success1);
	    //  Boolean success1 = (Boolean) magentoSoapClient.callSingle(ResourcePath.ShoppingCartCustomerSet, callParams);
	      
	    //  System.out.println("Set Cutomer In Cart result:"+success1);
	      /*
	       * --------------------------------------Product Set---------------------------------------------------------
	       */
	      
	      List<Object> params1 = new LinkedList<Object>();
	      
	      Map<String, Object> props = new HashMap<String, Object>();
	      props.put("product_id", productId);
	      props.put("qty", quantity);
	     // props.put("sku", "abcd");
	      params1.add(props);
	      Boolean success2 = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartProductAdd, new Object[] { cart.getId(),params1});
	      System.out.println("Set Product In Cart result:"+success2);
	      
	      
	      
	      /*
	       * --------------------------------------Customer Address Set---------------------------------------------------------
	       */
	      

			CustomerAddress shipAddr = null;
			CustomerAddress billAddr = null;
			List<CustomerAddress> customerAddresses=customerAddressRemoteService.list(cutomerId);
			for (CustomerAddress customerAddress : customerAddresses) {
				    shipAddr=customerAddress;
			    	billAddr=customerAddress;
				    shipAddr.setDefaultBilling(false);
				    shipAddr.setDefaultShipping(true);
				    billAddr.setDefaultBilling(true);
				    billAddr.setDefaultShipping(false);		  
			}
			
			CartAddress cartShipAddr = CartAddress.fromAttributes(shipAddr.getAllProperties());
			CartAddress cartBillAddr = CartAddress.fromAttributes(billAddr.getAllProperties());
			
			cart.setBillingaddress(cartBillAddr);
			cart.setShippingAddress(cartShipAddr);
			
	      
	      List<Object> list = new LinkedList<Object>();
	      cart.getShippingAddress().setType(Type.Shipping);
	      cart.getBillingAddress().setType(Type.Billing);
	      list.add(cart.getShippingAddress().serializeToApi());
	      list.add(cart.getBillingAddress().serializeToApi());

	      Boolean success = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartCustomerAddresses, new Object[] { cart.getId(), list});
	      System.out.println("success add customer "+success);
	      
	      
	      Boolean success5 = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartSetShippingInfo, new Object[] {cart.getId(),"flatrate_flatrate"});
	      System.out.println("set shipping method "+success5);
	      
	      //cashondelivery
	      List<Object> list1 = new LinkedList<Object>();
	     // list1.add("checkmo");
	      Map<String, Object> hashMapProperties = new HashMap<String, Object>();
	      hashMapProperties.put("method","checkmo");
	      list1.add(hashMapProperties);
	      Boolean success6 = (Boolean) magentoSoapClient.callArgs(ResourcePath.ShoppingCartSetPaymentInfo, new Object[] {cart.getId(),hashMapProperties});
	      System.out.println("set payemnt method "+success6);
	   
	      
	      
	      Map<String, Object> callParams5 = new HashMap<String, Object>();
	      callParams5.put("quoteId", cart.getId());
	     // callParams.put("storeId", cart.getStoreId());

	      String success7 = (String) magentoSoapClient.callSingle(ResourcePath.ShoppingCartOrder, callParams5);
	      System.out.println("sucessfully"+success7);
	}
}
