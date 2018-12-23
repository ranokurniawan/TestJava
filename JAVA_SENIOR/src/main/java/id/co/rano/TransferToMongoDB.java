package id.co.rano;

import java.util.List;
import java.util.Scanner;

import id.co.rano.documents.Customer;
import id.co.rano.documents.Employee;
import id.co.rano.documents.OrderDetails;
import id.co.rano.documents.Orders;
import id.co.rano.documents.Product;
import id.co.rano.documents.ShippingMethod;
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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class TransferToMongoDB implements CommandLineRunner{
	
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
		SpringApplication.run(TransferToMongoDB.class);
	}

	@SuppressWarnings("resource")
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				MongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx
				.getBean("mongoTemplate");
		
		int choiceRun;
		Scanner scanInt = new Scanner(System.in);
		System.out.print(consoleService.getPilihRunApp());
		choiceRun = scanInt.nextInt();
		
		if (choiceRun == 1) {
			/**
			 * Import Customer
			 */
			List<String> listStringCustomer = Utility.getListData(consoleService.getCsvDataCustomer());
			List<Customer> listCustomers = customersService.getListCustomer(listStringCustomer, consoleService.getDelimiterDataCustomer());
			listCustomers.forEach(customer -> {
				mongoOperation.save(customer);
			});
			
			/**
			 * Import Employee
			 */
			List<String> listStringEmployee = Utility.getListData(consoleService.getCsvDataEmployee());
			List<Employee> listEmployees = employeesService.getListEmployee(listStringEmployee, consoleService.getDelimiterDataEmployee());
			listEmployees.forEach(employee -> {
				mongoOperation.save(employee);
			});
			
			/**
			 * Import Product
			 */
			List<String> listStringProduct = Utility.getListData(consoleService.getCsvDataProduct());
			List<Product> listProducts = productsService.getListProduct(listStringProduct, consoleService.getDelimiterDataProduct());
			listProducts.forEach(product -> {
				mongoOperation.save(product);
			});
			
			/**
			 * Import ShippingMethod
			 */
			List<String> listStringShippingMethod = Utility.getListData(consoleService.getCsvDataShippingmethod());
			List<ShippingMethod> listShippingMethods = shippingMethodService.getListShippingMehotd(listStringShippingMethod, consoleService.getDelimiterDataShippingmethod());
			listShippingMethods.forEach(shippingMethod -> {
				mongoOperation.save(shippingMethod);
			});
			
			/**
			 * Import Orders
			 */
			List<String> listStringOrder = Utility.getListData(consoleService.getCsvDataOrder());
			List<Orders> listOrders = ordersService.getListOrder(listStringOrder, consoleService.getDelimiterDataOrder());
			listOrders.forEach(order -> {
				mongoOperation.save(order);
			});
			
			/**
			 * Import Orders Detail
			 */
			List<String> listStringOrderDetail = Utility.getListData(consoleService.getCsvDataOrderDetail());
			List<OrderDetails> listOrderDetails = orderDetailsService.getListOrderDetail(listStringOrderDetail, consoleService.getDelimiterDataOrderDetail());
			listOrderDetails.forEach(orderDetail -> {
				mongoOperation.save(orderDetail);
			});
		} else if (choiceRun == 2) {
			/**
			 * Find by city = Irvine
			 */
			Query findCustomerQuery = new Query();
			findCustomerQuery.addCriteria(Criteria.where("city").is("Irvine"));
			Customer findCustomer = mongoOperation.findOne(findCustomerQuery, Customer.class);
			System.out.println(findCustomer.toString());
			
			/**
			 * Find All Order Customer with employee Adam Barr
			 */
			Query findOrderQuery = new Query();
			findOrderQuery.addCriteria(Criteria.where("employee.firstName").is("Adam").andOperator(Criteria.where("employee.lastName").is("Barr")));
			List<Orders> findOrder = mongoOperation.find(findOrderQuery, Orders.class);
			findOrder.forEach(data -> {
				System.out.println(data.toString());
			});
			
			/**
			 * Find All Product with customer Contoso, Ltd
			 */
			Query findOrderDetailQuery = new Query();
			findOrderDetailQuery.addCriteria(Criteria.where("orders.customer.companyName").is("Contoso, Ltd"));
			List<OrderDetails> findOrderDetail = mongoOperation.find(findOrderDetailQuery, OrderDetails.class);
			findOrderDetail.forEach(data -> {
				System.out.println(data.toString());
			});
			
			/**
			 * Find All Order via UPS Ground
			 */
			Query findOrderDetailQuery1 = new Query();
			findOrderDetailQuery1.addCriteria(Criteria.where("orders.shippingMethod.shippingMethod").is("UPS Ground"));
			List<OrderDetails> findOrderDetail1 = mongoOperation.find(findOrderDetailQuery1, OrderDetails.class);
			findOrderDetail1.forEach(data -> {
				System.out.println(data.toString());
			});
		}
		scanInt.close();
	}

}
