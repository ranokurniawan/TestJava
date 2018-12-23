package id.co.rano.service;

import id.co.rano.documents.ShippingMethod;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService {

	public List<ShippingMethod> getListShippingMehotd(List<String> listData, String delimiter){
		List<ShippingMethod> listShippingMethodEntities = new ArrayList<ShippingMethod>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listShippingMethodEntities.add(new ShippingMethod(Long.valueOf(splitData[0]),
					splitData[1]));
		});
		return listShippingMethodEntities;
	}
	
}
