package id.co.rano;

import java.sql.SQLException;
import java.util.List;

import id.co.rano.entity.CustomersEntity;
import id.co.rano.entity.EmployeesEntity;
import id.co.rano.entity.OrderDetailsEntity;
import id.co.rano.entity.OrdersEntity;
import id.co.rano.entity.ProductsEntity;
import id.co.rano.entity.ShippingMethodEntity;
import id.co.rano.manager.Utility;
import id.co.rano.service.ConsoleService;
import id.co.rano.service.CustomersService;
import id.co.rano.service.EmployeesService;
import id.co.rano.service.OrderDetailsService;
import id.co.rano.service.OrdersService;
import id.co.rano.service.ProductsService;
import id.co.rano.service.ShippingMethodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransferFromCSV implements CommandLineRunner{
	
	@Autowired
	private ConsoleService consoleService;
	
	@Autowired
	private CustomersService customersService;
	
	@Autowired
	private EmployeesService employeesService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ShippingMethodService shippingMethodService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TransferFromCSV.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/**
		 * Data Customer
		 */
		List<String> listDataCust = Utility.getListData(consoleService.getCsvDataCustomer());
		List<CustomersEntity> listCustomersEntities = customersService.getListCustomer(listDataCust, consoleService.getDelimiterDataCustomer());
		listCustomersEntities.forEach(customerEntity -> {
			try {
				customersService.saveDataCustomer(customerEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		/**
		 * Data Employee
		 */
		List<String> listDataEmp = Utility.getListData(consoleService.getCsvDataEmployee());
		List<EmployeesEntity> listEmployeesEntities = employeesService.getListEmployee(listDataEmp, consoleService.getDelimiterDataEmployee());
		listEmployeesEntities.forEach(employeeEntity -> {
			try {
				employeesService.saveDataEmployee(employeeEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		/**
		 * Data Product
		 */
		List<String> listDataProd = Utility.getListData(consoleService.getCsvDataProduct());
		List<ProductsEntity> listProductsEntities = productsService.getListProduct(listDataProd, consoleService.getDelimiterDataProduct());
		listProductsEntities.forEach(productEntity -> {
			try {
				productsService.saveDataProduct(productEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		/**
		 * Data Shippingmethod
		 */
		List<String> listDataShip = Utility.getListData(consoleService.getCsvDataShippingmethod());
		List<ShippingMethodEntity> listShippingMethodEntities = shippingMethodService.getListShippingMehotd(listDataShip, consoleService.getDelimiterDataShippingmethod());
		listShippingMethodEntities.forEach(shippingMethodEntity -> {
			try {
				shippingMethodService.saveDataShippingMethod(shippingMethodEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		/**
		 * Data Order
		 */
		List<String> listDataOrder = Utility.getListData(consoleService.getCsvDataOrder());
		List<OrdersEntity> listOrdersEntities = ordersService.getListOrder(listDataOrder, consoleService.getDelimiterDataOrder());
		listOrdersEntities.forEach(ordersEntity -> {
			try {
				ordersService.saveDataOrder(ordersEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		/**
		 * Data Order Detail
		 */
		List<String> listDataOrderDetail = Utility.getListData(consoleService.getCsvDataOrderDetail());
		List<OrderDetailsEntity> listOrderDetailsEntities = orderDetailsService.getListOrderDetail(listDataOrderDetail, consoleService.getDelimiterDataOrderDetail());
		listOrderDetailsEntities.forEach(orderDetailsEntity -> {
			try {
				orderDetailsService.saveDataOrderDetail(orderDetailsEntity);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		System.out.println("Data berhasil di import...");
	}

}
