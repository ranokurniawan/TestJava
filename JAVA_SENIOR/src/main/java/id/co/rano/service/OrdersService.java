package id.co.rano.service;

import id.co.rano.MongoConfig;
import id.co.rano.documents.Customer;
import id.co.rano.documents.Employee;
import id.co.rano.documents.Orders;
import id.co.rano.documents.ShippingMethod;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(
			MongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");
	
	public List<Orders> getListOrder(List<String> listData, String delimiter){
		List<Orders> listOrdersEntities = new ArrayList<Orders>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			if (splitData[3].equals("")) {
				splitData[3] = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			} else {
				String[] splitDate = splitData[3].split("/");
				splitData[3] = splitDate[2].concat("-").concat(splitDate[1]).concat("-").concat(splitDate[0]);
			}
			if (splitData[5].equals("")) {
				splitData[5] = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			} else {
				String[] splitDate = splitData[5].split("/");
				splitData[5] = splitDate[2].concat("-").concat(splitDate[1]).concat("-").concat(splitDate[0]);
			}
			if (splitData[7].equals("")) {
				splitData[7] = "0";
			}
			if (splitData[8].equals("")) {
				splitData[8] = "0";
			}
			listOrdersEntities.add(new Orders(Long.valueOf(splitData[0]), 
					mongoOperation.findById(Long.valueOf(splitData[1]), Customer.class), 
					mongoOperation.findById(Long.valueOf(splitData[2]), Employee.class), 
					splitData[3], 
					splitData[4], 
					splitData[5], 
					mongoOperation.findById(Long.valueOf(splitData[6]), ShippingMethod.class), 
					Double.parseDouble(splitData[7].replace(",", ".")), 
					Double.parseDouble(splitData[8].replace(",", ".")), 
					splitData[9].charAt(0), null));
		});
		return listOrdersEntities;
	}
	
}
