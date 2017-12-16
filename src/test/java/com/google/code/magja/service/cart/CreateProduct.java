package com.google.code.magja.service.cart;

import java.util.ArrayList;
import java.util.List;

import com.google.code.magja.model.category.Category;
import com.google.code.magja.model.product.Product;
import com.google.code.magja.model.product.ProductAttributeSet;
import com.google.code.magja.model.product.ProductType;
import com.google.code.magja.model.product.Visibility;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.product.ProductRemoteService;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapConfig;

public class CreateProduct {
	public static void main(String[] args) throws Exception {
	
		String apiUser = "rahul";
	    String apiKey = "agile@123";
	    String remoteHost = "http://192.168.1.241:81/magento/api/soap/";
	    

		SoapConfig soapConfig = new SoapConfig(apiUser, apiKey, remoteHost);
		MagentoSoapClient magentoSoapClient = new MagentoSoapClient(soapConfig);
	    final RemoteServiceFactory remoteServiceFactory = new RemoteServiceFactory(magentoSoapClient);
	    
		ProductRemoteService productService=remoteServiceFactory.getProductRemoteService();
		 	

		Product product = new Product();
		product.setSku("ABCC");
		product.setName("Lovely Umbrella");
		product.setShortDescription("This is a short description");
		product.setDescription("This is a description for Product");
		product.setPrice(250.99);
		product.setCost(100.22);
		product.setEnabled(true);
		product.setWeight(0.500);
		product.setType(ProductType.SIMPLE);
		product.setAttributeSet(new ProductAttributeSet(4, "Default"));

		// category
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(2));
		product.setCategories(categories);


		product.setWebsites(new Integer[] { 1 });
		product.setVisibility(Visibility.CATALOG_SEARCH);

		// inventory
		product.setQty(new Double(20));
		product.setInStock(true);
		product.setMetaTitle("meta title");
		product.setMetaDescription("meta description");
		product.setMetaKeyword("keyword");

		// Optional: you can set the properties directly by-passing the setter like too:
		product.set("meta_description", "one two tree");

		// then, we just instantiate the service to persist the product
		productService.add(product);

	}
}
