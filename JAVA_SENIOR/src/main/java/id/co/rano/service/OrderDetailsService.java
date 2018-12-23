package id.co.rano.service;

import id.co.rano.MongoConfig;
import id.co.rano.documents.OrderDetails;
import id.co.rano.documents.Orders;
import id.co.rano.documents.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(
			MongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");
	
	public List<OrderDetails> getListOrderDetail(List<String> listData, String delimiter){
		List<OrderDetails> listOrderDetailsEntities = new ArrayList<OrderDetails>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);			
			listOrderDetailsEntities.add(new OrderDetails(Long.valueOf(splitData[0]), 
					mongoOperation.findById(Long.valueOf(splitData[1]), Orders.class), 
					mongoOperation.findById(Long.valueOf(splitData[2]), Product.class), 
					Integer.valueOf(splitData[3]), Double.parseDouble(splitData[4].replace(",", ".")), 
					Double.parseDouble(splitData[5].replace("%", "").replace(",", "."))));
		
		});
		return listOrderDetailsEntities;
	}
	
}
