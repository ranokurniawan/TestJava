package id.co.rano.service;

import id.co.rano.documents.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeesService {
	
	public List<Employee> getListEmployee(List<String> listData, String delimiter){
		List<Employee> listEmployeesEntities = new ArrayList<Employee>();
		listData.forEach(loop -> {
			String[] splitData = loop.split(delimiter);
			listEmployeesEntities.add(new Employee(Long.valueOf(splitData[0]), splitData[1],
					splitData[2], splitData[3], splitData[4]));
		});
		return listEmployeesEntities;
	}
	
}
