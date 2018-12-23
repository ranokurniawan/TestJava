package id.co.rano.service;

import id.co.rano.documents.Product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductsService {

	public List<Product> getListProduct(List<String> listData, String delimiter){
		List<Product> listProductsEntities = new ArrayList<Product>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listProductsEntities.add(new Product(Long.valueOf(splitData[0]), splitData[1],
					Double.parseDouble(splitData[2].replace(",", ".")), splitData[3].charAt(0)));
		});
		return listProductsEntities;
	}
	
}
