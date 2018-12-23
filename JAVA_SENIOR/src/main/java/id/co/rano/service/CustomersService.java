package id.co.rano.service;

import id.co.rano.documents.Customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomersService {

	public List<Customer> getListCustomer(List<String> listData, String delimiter){
		List<Customer> listCustomersEntities = new ArrayList<Customer>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listCustomersEntities.add(new Customer(Long.valueOf(splitData[0]), 
					splitData[1], splitData[2], splitData[3], splitData[4], 
					splitData[5], splitData[6], splitData[7], splitData[8], 
					splitData[9], splitData[10], splitData[11], 
					splitData[12], splitData[13], splitData[14], 
					splitData[15], splitData[16]));
		});
		return listCustomersEntities;
	}	
}
